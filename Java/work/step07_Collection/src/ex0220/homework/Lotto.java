package ex0220.homework;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
/**
 * Lotto 번호를 TreeSet으로 뽑고 내림차순으로 정렬하기
 * */
//extends TreeSet<Integer>을 해도 좋다.
public class Lotto {
	private static final int LOTTO_COUNT = 6;
	
	public Lotto() {}
	
	public int createNo() {
		int nansu = (int)(Math.random()*45)+1;
		return nansu;
	}
	//Random r = new Random();
	//int no = r.nextInt(45)+1;
	
	public Set<Integer> generateLottoNo () {
		Set<Integer> lottoSet = new TreeSet<>(Collections.reverseOrder());
		while(lottoSet.size()<LOTTO_COUNT) {
			//Set은 중복이 애초에 안 되기 때문에 사이즈가 6이 될 때까지 반복하기만 하면 된다.
			lottoSet.add(createNo());
		}
		return lottoSet;
	}

	
}
