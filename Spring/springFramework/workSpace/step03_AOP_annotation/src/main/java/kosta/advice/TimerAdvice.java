package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("advice")
@Aspect //<aop:aspect ref="advice"> 
public class TimerAdvice {
	/**
	 * 공통기능(부가기능)
	 * : around 방식(사전 처리, 사후 처리)
	 * 
	 * : 기능
	 * 	 사전의 현재시간 구한다
	 * 	 사후에 현재 시간 구해서 (사후 - 사전) 핵심기능을 실행한 실행시간을 측정한다.
	 * 
	 * @param: ProceedingJoinPoint(사전, 사후일 때 다음 target 대상을 호출할 수 있는 메소드를 제공)
	 * 		   JoinPoint(타겟 대상의 메서드에 대한 정보를 조회할 수 있는 메소드 제공)라는 객체를 상속받은 객체
	 * 		   어디까지가 사전처리이고 갔다가 다시 와서 어디서부터 사후처리인지를 구별할 수 있게 하기 위해 ProceedingJoinPoint를 사용
	 * 
	 * @return: Object는 target 대상이 리턴한 값을 리턴해준다.
	 * 
	 * */
	@Around("execution(* kosta.service.*.*(..))") //pointcut
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//사전처리
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG] "+methodName+ "호출 되기 전입니다.");
		
		Object params [] = joinPoint.getArgs(); //타겟 대상 메소드의 매개변수(인수) 조회
		for(Object param: params) {
			System.out.println(param);
		}
		
		//현재 시간
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed(); //다음 advice or target method를 호출한다. advice가 advice를 호출가능
		
		//사후처리
		sw.stop();
		System.out.println("[LOG] "+methodName+ "호출 된 후입니다.");
		System.out.println("[LOG] "+methodName+ "의 총 실행시간(ms)="+sw.getTotalTimeMillis());
		System.out.println("[LOG] "+methodName+ "의 리턴값 obj="+obj);
		
		
		return obj;
	}
}
