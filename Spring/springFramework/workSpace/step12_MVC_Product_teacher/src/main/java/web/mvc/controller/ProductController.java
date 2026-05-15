package web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.service.ProductService;

@Controller
@Slf4j
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
	/**
	 * 전체검색
	 * */
	@RequestMapping("/")
	public ModelAndView selectAll() {
		log.info("전체검색  call...");
		
		//서비스 호출
		List<ProductDTO> list = productService.select();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productList");// WEB-INF/views/productList.jsp이동
		mv.addObject("productList",list); //jsp문서에서 ${productList} 사용하고 있다.
		return mv;
	}
	
	/**
	 * 상품등록폼
	 * */
	@RequestMapping("/{url}")
	public void url(){ }
	
	/**
	 * 등록하기 
	 * */
	@PostMapping("/products")
	public String insert(ProductDTO productDTO){
		
		productDTO.setDetail( productDTO.getDetail().replace("<", "&lt;") ) ;
		
		productService.insert(productDTO);
		
		return "redirect:/";//redirect방식으로 / 요청의 controller 를 실행-> redirect(PRG패턴)
		
	}
	
	
	
	/**
	 * 상세보기
	 * */
	@GetMapping("/read")
	public ModelAndView read(String code) {
		ProductDTO product =productService.selectByCode(code);
		
		
		return new ModelAndView("read", "product", product);
	}
	
	/**
	 * 수정폼
	 * */
	@GetMapping("/updateForm/{code}")
	//public String updateForm(String code) { //url주소?code=A01
	public String updateForm(@PathVariable String code , Model model) {//{code}
		ProductDTO product = productService.selectByCode(code);
		
		model.addAttribute("product", product);
		
		return "updateForm"; //WEB-INF/views/updateForm.jsp
	}
	
	/**
	 * 수정하기
	 * */
	@PostMapping("/products/{code}")
	public String update(@PathVariable String code ,
			@ModelAttribute("product") ProductDTO productDTO) { 
	    System.out.println("code = " + code);
	    //productDTO.setCode(code2);
	    System.out.println("productDTO = " + productDTO);
	    
		productService.updateByCode(productDTO);
		
		
		return "read";// WEB-INF/views/read.jsp 이동
	}
	
	/**
	 * 삭제하기
	 * */
	@RequestMapping("/del/{code}")
	public String delete(@PathVariable String code) {
		productService.delete(code);
		
		return "redirect:/"; //redirect방식으로 / 요청  controller가 실행됨.
	}
}





