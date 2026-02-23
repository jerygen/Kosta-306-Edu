package com.ws05.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ws05.dto.AccountDto;
import com.ws05.dto.InstallAccountDto;
import com.ws05.dto.LoanAccountDto;
import com.ws05.dto.SavingAccountDto;
import com.ws05.dto.UserDto;

public class BankService {	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 리스트 객체 생성
	 * */
	List<UserDto> userList;
	List<AccountDto> accountList;
	
	public BankService() {
        userList = new ArrayList<UserDto>(); 
		accountList = new ArrayList<AccountDto>(); 

		userList.add( new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false) );
		userList.add( new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true) );
		userList.add( new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false) );
		
		accountList.add( new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000) );
		
		accountList.add( new SavingAccountDto(10, "00100101001001", 500, 111, 100) );
		
		accountList.add( new LoanAccountDto(60, "00600606006006", 500, 333, "House") );
		accountList.add( new LoanAccountDto(30, "00300303003003", 0, 111, "Building") );
		
		accountList.add( new SavingAccountDto(70, "00700707007007", 500, 333, 200) );
		
		accountList.add( new LoanAccountDto(50, "00500505005005", 200, 222, "Car") );
		accountList.add( new SavingAccountDto(40, "00400404004004", 1000, 222, 50) );
	}
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public List<AccountDto> getAccountList(int userSeq) { // 100 
		 int searchAccountCount=0; //인수로 전달된 userSeq에 해당하는 계좌의 개수를 체크 
		 //리턴해서 나갈 배열의 개수를 미리 알아내여 선언하기 위해 반복문필요 
		 for(AccountDto account :accountList) {
				if(account.getUserSeq() == userSeq) {
					 //찾았다!!
					searchAccountCount++;
				}
		 }
		//위에서 찾은 정보를 바탕으로  AccountDto배열에서 계좌정보를 찾아서  리턴해준다.
		//찾은 고객의 계좌의 수만큼 배열을 생성해서 그 배열을 리턴
		if(searchAccountCount==0)
			return null;
		
		List<AccountDto> searchAccountDtoList =  new ArrayList<>();
		
		for(AccountDto account :accountList) {
			if(account.getUserSeq() == userSeq) {
				searchAccountDtoList.add(account);	
			}
		}
		return searchAccountDtoList;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		for(UserDto user:userList) {
			if(user.getUserSeq()==userSeq) {
				return user;
			}
		}
		return null;
	}
	/**
	 * 신규로, 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
	 * */
	public List<AccountDto> getAccountList(){
		return accountList;
	}
	/**
	 * 4) 신규로, 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
       : Comparable Interface 를 이용한다.
       */
	public List<AccountDto> getAccountListSortByBalance() {
		List<AccountDto> shallowCopy = new ArrayList<>(accountList);
		Collections.sort(shallowCopy, (e1, e2)->e1.getBalance()-e2.getBalance());
		
		return shallowCopy;
	}
	/**
	 * 5)  신규로, 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다. 
	 * 만약 사용자 일련 번호 같은면 잔액을 기준으로 내림차순
       : Comparator Interface 를 이용한다.
       */
	public List<AccountDto> getAccountListSortByUserSeq() {
		List<AccountDto> shallowCopy = new ArrayList<>(accountList);
		Collections.sort(shallowCopy, (e1, e2)->e1.getUserSeq()-e2.getUserSeq());
		//삼항식 구조, 조건식 ? 참 : 거짓
//		Collections.sort(shallowCopy, (e1, e2)->e1.getUserSeq()==e2.getUserSeq() ? 
//				e2.getBalance()-e1.getBalance(): e1.getUserSeq()-e2.getUserSeq());
		return shallowCopy;
	}

	
}










