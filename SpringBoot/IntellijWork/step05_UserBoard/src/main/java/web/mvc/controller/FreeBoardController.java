package web.mvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.mvc.domain.FreeBoard;
import web.mvc.service.FreeBoardService;

import org.springframework.data.domain.Pageable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @RequestMapping("/{url}")
    public void url(){}

    @RequestMapping("/list")
    public String list(Model model) {
        //List<FreeBoard> freeList  = freeBoardService.selectAll();
        //model.addAttribute("freeList",freeList);

        Pageable pageable = PageRequest.of(0, 10);
        Page<FreeBoard> page = freeBoardService.selectAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("freeList", page.getContent());

        return "board/list";
    }

    @RequestMapping("/insert")
    public String insert(FreeBoard freeBoard) {
        freeBoardService.insert(freeBoard);
        return "redirect:/board/list";
    }

    @RequestMapping("/read/{bno}")
    public String read(@PathVariable("bno") Long bno, HttpSession session, Model model) {
        // 1. 세션에서 "읽은 게시글 번호 목록(Set)"을 꺼내옵니다.
        Set<Long> viewedBoards = (Set<Long>) session.getAttribute("viewedBoards");

        // 2. 만약 세션에 목록이 없다면 처음 방문한 것이므로 새로 생성합니다.
        // (중복 저장을 막기 위해 List 대신 Set을 사용합니다)
        if (viewedBoards == null) {
            viewedBoards = new HashSet<>();
        }

        // 3. 현재 게시글 번호(bno)가 목록에 있는지 확인하여 state 결정
        boolean state;
        if (viewedBoards.contains(bno)) {
            state = false; // 이미 읽은 글이면 조회수 증가 안 함
        } else {
            state = true;  // 처음 읽는 글이면 조회수 증가
            viewedBoards.add(bno); // 읽은 글 목록에 현재 번호 추가
            session.setAttribute("viewedBoards", viewedBoards); // 세션에 다시 저장
        }

        FreeBoard freeBoard = freeBoardService.selectBy(bno, state);
        model.addAttribute("board", freeBoard);

        return  "/board/read";
    }

    @RequestMapping("/updateForm")
    public String updateForm(@RequestParam("bno") Long bno, Model model) {
        FreeBoard freeBoard = freeBoardService.selectBy(bno, false);
        model.addAttribute("board", freeBoard);

        return "/board/update";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("bno") Long bno, FreeBoard freeBoard) {
        freeBoard.setBno(bno);
        FreeBoard board = freeBoardService.update(freeBoard);

        return "redirect:/board/read/" + board.getBno();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("bno") Long bno, @RequestParam("password") String password) {
        freeBoardService.delete(bno, password);
        return "redirect:/board/list";
    }



}
