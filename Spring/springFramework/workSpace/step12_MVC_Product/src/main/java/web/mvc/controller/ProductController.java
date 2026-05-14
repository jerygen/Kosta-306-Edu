package web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/products")
	public String insert(ProductDTO productDTO) {
		productService.insert(productDTO);
		return "redirect:/";
	}
	
	/**
	 * 상품 상세보기
	 * */
	@RequestMapping("/read")
	public ModelAndView selectByCode(@RequestParam("code") String code) {
		ProductDTO product = productService.selectByCode(code);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("read");
		mv.addObject("product", product );
		
		return mv;	
	}
	
	/**
	 * 상품 삭제
	 * */
	@RequestMapping("/del/{code}")
	public String delete(@PathVariable String code) {
		productService.delete(code);
		return "redirect:/";
	}
	
	/**
	 * 상품 수정 폼
	 * */
	@RequestMapping("/updateForm/{code}")
	public ModelAndView url2(@PathVariable("code") String code) {
		ProductDTO product = productService.selectByCode(code);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateForm");
		mv.addObject("product", product);
		
		return mv;
	}
	
	/**
	 * 상품 수정
	 * */
	@RequestMapping("/products/{code}")
	public String update(@PathVariable String code, ProductDTO productDTO) {
		productDTO.setCode(code);		
		productService.updateByCode(productDTO);
		return "redirect:/read?code="+code;
	}
	
	
}
