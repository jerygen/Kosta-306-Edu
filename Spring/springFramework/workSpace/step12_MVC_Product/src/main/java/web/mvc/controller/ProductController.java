package web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.service.ProductService;

@Controller
@Slf4j
public class ProductController {
	//ModelAndView로 진행, ajax 아님
	
	@Autowired
	private ProductService productService; 
	
	/**
	 * 전체 검색
	 * */
	@RequestMapping("/")
	public ModelAndView selectAll() {
		log.info("전체검색 call...");
		
		//서비스 호출
		List<ProductDTO> list = productService.select();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productList"); //WEB-INF/views/productList.jsp 이동
		mv.addObject("productList", list); //productList.jsp 에 있는 이름으로  ${requestScope.productList}
		
		return mv;
	}
	
	/**
	 * 상품 등록 폼
	 * 실제 뷰의 파일이름과 요청 이름이 같으므로 void 가능
	 * */
	@RequestMapping("/insertForm")
	//@RequestMapping("/{url}")
	public void url() {
		
	}
	
	/**
	 * 상품 등록
	 * */
	
	
}
