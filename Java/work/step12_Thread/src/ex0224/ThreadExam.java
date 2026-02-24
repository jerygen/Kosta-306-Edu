package ex0224;
/**
 * 숫자를 100번 출력하는 스레드 - 상속
 * */
class NumberThread extends Thread{
	int sum;//총합
	public NumberThread(String name) {
		super(name);
	}
	/**
	 * 스레드로 동작할 기능을 작성
	 * */
	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			System.out.println(super.getName() + "=> "+i);
			sum+=i;//누적
			
			//Thread.yield();//스레드 양보
			try {
				Thread.sleep(10);//0.01초 정지 상태 -> 1초 지나면 runnable 상태로 간다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(super.getName()+" End --------");
	}
}
//////////////////////////////
/**
 * Alpha을 출력하는 스레드 - 구현
 * */
class AlphaThread implements Runnable{
	
	@Override
	public void run() {
		Thread th = Thread.currentThread();//현재 스레드를 알 수 있는 메소드
		
		for(char ch='A';ch<='Z';ch++) {
			System.out.println(th.getName()+" => "+ch);
			//Thread.yield();//스레드 양보
			
			try {
				Thread.sleep((int)(Math.random()*100));//0.01초 정지 상태 -> 1초 지나면 runnable 상태로 간다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(th.getName()+" End------------");
	}
	
}

////////////////////////////////////////
public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("---메인 시작---------");
		NumberThread th1 = new NumberThread("첫번째 thread");
		Thread th2 = new NumberThread("두번째 thread");
		
		Thread th3 = new Thread(new AlphaThread(), "세번째 thread");
		
		//스레드 총 4개(+main), 멀티 스레드로 동작하기 위해서는 run을 직접 호출하지 않는다.
		/*th1.run();
		th2.run();
		th3.run();*/
		
		//main이 먼저 그냥 끝나버림.
		th1.start();
		th2.start();
		th3.start();
		
		/*try {
			th1.join();//th1 스레드가 일을 마무리할 때까지 main 스레드가 정지상태, 이 메소드를 호출한 스레드에서 정지상태가 되기 때문에 현재는 메인스레드가 정지 상태
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		
		System.out.println("총합 = "+th1.sum);
		
		System.out.println("---메인 끝 ----------");
	}

}
