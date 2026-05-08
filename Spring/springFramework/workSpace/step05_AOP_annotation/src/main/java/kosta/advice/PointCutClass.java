package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

/**
 * pointcut 정의 하는 클래스
 * */
public class PointCutClass {
	
	/**
	 * log 기록을 할 포인트컷 정의
	 * */
	@Pointcut("execution(* kosta.service.CustomerService.*(..))")
	public void aa() {}
	
	/**
	 * transaction 처리할 포인트컷
	 * */
	@Pointcut("execution(* kosta.service.CustomerService.*())")
	public void bb() {}
	
}
