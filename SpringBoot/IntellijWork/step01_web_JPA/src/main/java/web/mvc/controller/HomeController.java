package web.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        log.info("home 진입");
        model.addAttribute("message","오늘은 수요일");
        return "index"; //WEB-INF/views/index.jsp 이동
    }
}
