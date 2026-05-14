package kosta.test.advice;

import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;


public class LogAdvice {
	
	private FileWriter fw;
	
	public LogAdvice() {
        try {
            // 파일 경로를 지정하여 FileWriter 생성 (true는 이어쓰기 모드)
            fw = new FileWriter("C:\\KOSTA\\Spring\\springFramework\\workSpace\\ex_AOP\\log\\log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            // 핵심 로직 수행 전 로그 기록
            fw.write("메소드 호출 전...\n");
            fw.flush();
            
            Object result = joinPoint.proceed(); // 대상 메소드 실행
            
            // 핵심 로직 수행 후 로그 기록
            fw.write("메소드 호출 후...\n");
            fw.flush();
            
            return result;
        } finally {
            
        }
    }
}
