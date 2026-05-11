package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SelectController 실행 입니다.....");
		
		request.setAttribute("message", "select의 결과 입니다.");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp"); //redirect 변경 안 했기 때문에 forward 방시긍로 이동
		
		return mv; 
	}

}
