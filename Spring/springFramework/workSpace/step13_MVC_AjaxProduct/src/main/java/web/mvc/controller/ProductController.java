package web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.HttpsServer;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.service.ProductService;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
	/**
	 * 전체검색
	 * */
	@GetMapping
	public ResponseEntity<?> selectAll() {
		log.info("전체검색  call...");
		
		//서비스 호출
		List<ProductDTO> list = productService.select();
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	/**
	 * 등록하기 
	 * */
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ProductDTO productDTO){//json -> 자바 객체로 변환
		
		productDTO.setDetail( productDTO.getDetail().replace("<", "&lt;") ) ;
		
		int result = productService.insert(productDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	
	/**
	 * 상세보기
	 * */
	@GetMapping("/{code}")
	public ResponseEntity<?> read(@PathVariable String code) {
		ProductDTO product = productService.selectByCode(code);
		
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	/**
	 * 수정하기
	 * */
	@PutMapping("/{code}")
	public ResponseEntity<?> update(@PathVariable String code ,
			@ModelAttribute("product") ProductDTO productDTO) { 
	    System.out.println("productDTO = " + productDTO);
	    productDTO.setCode(code);
	    
		productService.updateByCode(productDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}
	
	/**
	 * 삭제하기
	 * */
	@RequestMapping("/{code}")
	public ResponseEntity<?> delete(@PathVariable String code) {
		productService.delete(code);
		
		return ResponseEntity.status(HttpStatus.OK).body("Success"); //redirect방식으로 / 요청  controller가 실행됨.
	}
}





