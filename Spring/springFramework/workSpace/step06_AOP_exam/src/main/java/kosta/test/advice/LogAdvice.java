package kosta.test.advice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LogAdvice {
	BufferedWriter bw;//null -> FileWriter에 입출력의 효과를 높이기 위해 Buffered 사용
	
	//LogAdvice가 소멸될 때 BufferedWriter도 닫아줘야 한다.
	public LogAdvice() { // logAdvice가 생성될 때 딱 한 번만 실행
		try {
			File file = new File("src/main/java/kosta/test/advice/log.txt");
		    bw = new BufferedWriter(new FileWriter(file ,true ));//true는 이어쓰기
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 공통의 기능 사전, 사후 처리 - around 
	 * */
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable {
		
		//사전
		String methodName = joinPoint.getSignature().getName();
		Object params [] = joinPoint.getArgs();
		
		bw.write(methodName+"호출 ");
		bw.write("인수의 개수  =  " + params.length + " / ");
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed();//다음 target 대상을 호출한다.(next Advice or joinpoint 메소드)
		
		sw.stop();
		
		//사후
		bw.write("리턴값  =  " + obj +" / ");
		bw.write("총 소요 ns  =  " +  sw.getTotalTimeNanos() +"ns");
		bw.newLine();
		
		bw.flush();
		
		return obj;
		
	}
	
	/**
	 * bean이 생성된 후 해야 할 일
	 * */
	@PostConstruct
	public void bb() {
		System.out.println("생성과 주입이 완료된 후~~~~");
	}
	
	/**
	 * Spring IoC Container가 종료될때 자원을 해지 하고 싶다.
	 * */
	@PreDestroy   
    public void aa() {
		try {
			System.out.println("---파일을 닫겠습니다.-------");
		}finally {
			try {
				bw.write("end....");
				bw.flush();
				bw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	////////////////////////////////////////////////////

}







