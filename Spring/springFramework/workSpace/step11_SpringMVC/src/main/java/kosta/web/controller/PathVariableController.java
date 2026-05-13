package kosta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PathVariableController {

	@RequestMapping("/{type}/{id}.do")
	public void aa(@PathVariable String type, @PathVariable String id) {
		log.info("aa 메소드 호출");
		log.info("type: {}, id:{}", type, id);
	}
	
	@RequestMapping("/{id}")
	public void bb(@PathVariable String id) {
		log.info("bb method call... id={}",id);
	}
	
	@RequestMapping("/{type}/{id}/{no}")
	public String cc(@PathVariable("type") String userType, @PathVariable String id, @PathVariable int no) {
		//@PathVariable을 안 붙이면 RequestParam("userType")을 의미 userType=값		
		log.info("cc call ... userType={}", userType);
		log.info("cc call ... id={}, no={}", id, no);
		
		//기능을 완료한 후에 다른 Controller를 실행하고 싶다.
		/**
		 * viewName에 
		 * 1. redirect:url주소  
		 * 2. forward:url주소
		 * */
		
		//return "/rem/a.do"; //WEB-INF/views/rem/a.do.jsp 이동
		return "redirect:/rem/a.do";
		//return "forward:/rem/a.do";
		
	}
}
