package ex0224;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("-----메인 시작합니다.-------");
		
		Bank bank = new Bank();
		
		CustomerThread th1 = new CustomerThread(bank, "입금자",true);
		CustomerThread th2 = new CustomerThread(bank, "출금자",false);
		
		th1.start();
		th2.start();		
		
		
		System.out.println("-----메인 끝입니다.-------");
	}

}
/////////////////////////
/**
 * 여러 스레드가 공유할 객체
 * 
 * @param: state는 true이면 입금, false이면 출금
 * */
class Bank{
	int balance;//잔액
	
	/**
	 * 제한자 synchronized 는 특정 스레드 synchronized 블럭안에서 일을 다 마무리 할때까지
	   다른 스레드가 제어권을 뺏어가지 못하도록 하는것. synchronized 블럭안에 있는 스레드가
	   lock을 가지고 있다고 하고 블럭빠져나가면 잠금이 풀린다.
	     
	   wait() : 현재 runing중인 스레드를 중지상태로 만듦
	   notify(), notifyAll() : wait()에 의해 중지상태인 스레드를 runnable상태로 만듦
	   주의 : wait(),notify(), notifyAll()는 반드시 synchronized블럭안에서 사용한다.
	*/
	//메소드 전체를 동기화처리한다. or 필요한 부분에만 동기화처리한다.
	public synchronized void balanceChange(String name, boolean state) {
		if(state) {//입금
			if(balance==0) {
			//synchronized (this) {
				System.out.print(name+"===> 현재 잔액: "+ balance+" / ");
				balance++;
				System.out.println(name+"===> 증가 후 현재 잔액: "+balance);
			//}
			}else {
				System.out.println(name+" 대기중 ~~~");
				try {
					wait();//현재 스레드를 정지상태로 옮긴다.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else {//인출
			if(balance==1) {
			//synchronized (this) {
				System.out.print(name+"===> 현재 잔액: "+ balance+" / ");
				balance--;
				System.out.println(name+"===> 감소 후 현재 잔액: "+balance);
			//}
			}else {
				System.out.println(name+" 대기중 ~~~");
				try {
					wait();//현재 스레드를 정지상태로 옮긴다.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		notifyAll();//wait()에 의해서 일시 정지중ㅇ니 스레드를 runnable 상태로 만든다.
	}//메소드 끝
}//클래스 끝
//////////////////////////////////////////////
/**
 * 입금 or 출금을 하게 된 스레드 객체
 * */
class CustomerThread extends Thread{
	//Bank bank = new Bank(); //이렇게 작성하면 Bank를 입금과 출금이 각각 가지게 되서 공유하는 게 아니게 된다.
	
	Bank bank;
	boolean state;
	CustomerThread(Bank bank, String name, boolean state){//이렇게 해야 입금, 출금스레드가 모두 같은 bank를 참조할 수 있게 된다.
		super(name);
		
		this.state=state;
		this.bank=bank;
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			bank.balanceChange(super.getName(), state);
		}
		
		System.out.println(super.getName()+"스레드 종료합니다.");
	}
}

