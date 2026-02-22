package ex0220.homework;

import java.util.Set;

public class MainApp {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		
		Set<Integer> lottoNo = lotto.generateLottoNo();
		System.out.println(lottoNo);
	}

}
