package web.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.domain.FreeBoard;
import web.mvc.domain.Reply;
import web.mvc.service.ReplyService;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @RequestMapping("/writeForm")
    public String writeForm(@RequestParam Long bno, Model model) {
        model.addAttribute("bno", bno);

        return "reply/write";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam Long bno, @RequestParam String content) {
        Reply reply = Reply.builder()
                            .content(content)
                            .freeBoard(new FreeBoard(bno))
                            .build();
        replyService.insert(reply);
        return "redirect:/board/read/"+bno;
    }

    @RequestMapping("/delete/{rno}/{bno}")
    public String delete(@PathVariable Long rno,@PathVariable Long bno) {
        replyService.delete(rno);
        return "redirect:/board/read/"+bno;
    }
}
