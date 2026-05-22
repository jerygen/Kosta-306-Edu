package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.repository.ReplyRepository;
import web.mvc.service.ReplyService;

@Controller
public class ReplyController {

    private ReplyService replyService;

    @RequestMapping("/reply/writeForm")
    public String writeForm() {
        return "reply/write";
    }

    @PostMapping("/reply/insert")
    public void insert(@RequestParam String content) {

    }
}
