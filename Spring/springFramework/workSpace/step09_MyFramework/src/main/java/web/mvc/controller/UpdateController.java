package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("updateController 입니다......");
		
		request.setAttribute("message", "수정완료 내용입니다...."); //전달하는 값이 있기 때문에 forward 방식으로 이동해야 한다.
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateResult.jsp");
		return mv;
	}

}
