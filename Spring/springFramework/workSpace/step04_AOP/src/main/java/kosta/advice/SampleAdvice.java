package kosta.advice;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {
	/**
	 * 사전처리
	 * */
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"의 사전 처리 before입니다.\n");
	}
	
	/**
	 * 사후처리(정상동작일 경우)
	 * */
	public void afterReturning(JoinPoint joinPoint, Object obj) {
		System.out.println("정상적으로 동작했을 떄 사후 처리입니다.");
		
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"의 리턴 값="+obj+"\n");
	}
	
	/**
	 * 사후처리(예외 발생)
	 * */
	public void afterThrowing(Throwable e) {
		System.out.println("예외가 발생했을 때 사후 처리입니다.");
		System.out.println("예외 정보 e="+e);
	}
	
	/**
	 * 사후처리(예외발생 여부 상관없이 무조건)
	 * */
	public void afterFinally() {
		System.out.println("예외발생 여부에 상관없이 무조건 사후처리 실행됩니다.");
	}
	
}
