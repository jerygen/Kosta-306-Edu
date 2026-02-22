package ex0220.homework;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private static final int LOTTO_COUNT = 6;
	
	public Lotto() {}
	
	public int createNo() {
		int nansu = (int)(Math.random()*45)+1;
		return nansu;
	}
	
	public Set<Integer> generateLottoNo () {
		Set<Integer> lottoSet = new TreeSet<>(Collections.reverseOrder());
		while(lottoSet.size()<LOTTO_COUNT) {
			lottoSet.add(createNo());
		}
		return lottoSet;
	}


}
