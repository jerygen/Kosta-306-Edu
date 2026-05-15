package web.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ResponseDTO;

@RestControllerAdvice //Controller에서 발생하는 예외를 공통(Advice)으로 처리하는 클래스 
@Slf4j
public class GlobalExceptionAdvice {
	
	@ExceptionHandler(MyErrorException.class)
	public ResponseEntity<?> error(MyErrorException e) {
		//e.printStackTrace();
		log.error("Error Message error {} " , e.getErrorCode().getMsg() );
		
		ResponseDTO dto = ResponseDTO.builder()
									 .msg(e.getErrorCode().getMsg())
									 .status(e.getErrorCode().getStatus())
									 .build();

		return ResponseEntity.status(e.getErrorCode().getStatus()).body(dto);
	}
	
}
