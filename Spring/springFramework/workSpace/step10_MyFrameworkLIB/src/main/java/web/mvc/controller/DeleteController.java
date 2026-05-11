package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DeleteController 입니다....");
		
		return new ModelAndView("index"); //ViewResolver를 통해서 실제로 어디로 갈 지 정해진다. //prefix + 뷰 이름 + suffix 연결 -> /index.jsp
	}

}
