package ex0205.homework;

import java.util.Arrays;

/**
 * 주제: 로또 번호 뽑기
 * 작성일: 2026.02.05
 * 작성자: 김미연
 * */
public class MakeLotto {
	
	/**
	 * 배열에 이미 들어간 숫자와 새로 만들어진 숫자를 비교해서 중복 체크
	 * */
	public boolean duplicateCheck(int [] arr, int num, int len) {
		//boolean형 메소드를 정의할 때 isDuplicate 이런식으로 이름을 지음
		for(int i=0;i<len;i++) {
			if(arr[i]==num) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 난수를 뽑고 중복이 없는 숫자들을 lotto 배열에 6개 넣는 메소드
	 * */
	public int [] saveNumber(int[] arr) {
		//save보다 create를 사용하는 게 좋음 그리고 굳이 리턴 값이 있을 필요없음
		//while문을 사용해서 하면 더 간결
		int array [] = new int [6];
		int len=0;
		for(int i=0;i<6;i++) {
			int nansu = (int)(Math.random()*45+1);
			array[i] = nansu;
			if(this.duplicateCheck(array, nansu, len)) len +=1;
			else i--;
		}
		return array;
		//System.out.println("중복 없음"+Arrays.toString(array)); 
	}
	
	/**
	 * 내림차순으로 정렬하는 메소드
	 * */
	public int [] decsendingSort(int [] array) {
		int temp;
		
		for(int i=0;i<6;i++) {
			for(int j=i;j>0;j--) {
				if(array[j]>array[j-1]) {
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int [] lotto = new int [6];
		
		MakeLotto ml = new MakeLotto();
	
		//중복 없는 값들 저장
		lotto = ml.saveNumber(lotto);
		//내림차순 정렬
		lotto = ml.decsendingSort(lotto);
		for(int i=0;i<6;i++) {
			System.out.print(lotto[i]+" ");
		}
	}
	
	
}
