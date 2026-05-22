package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
    @RequestMapping("/{url}")
    public void board() {
    }

    @RequestMapping("/list")
    public String list() {
        return "list";
    }



}
