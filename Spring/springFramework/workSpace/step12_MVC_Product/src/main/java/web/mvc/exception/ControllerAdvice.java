package web.mvc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView handleMyErrorException(MyErrorException e) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("error");
		mv.addObject("errStatus", e.getErrorCode().name());
		mv.addObject("errMessage", e.getErrorCode().getMsg());
		
		return mv;
	}
}
