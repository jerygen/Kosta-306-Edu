package com.ws06.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ws06.dto.AccountDto;
import com.ws06.dto.InstallAccountDto;
import com.ws06.dto.LoanAccountDto;
import com.ws06.dto.SavingAccountDto;
import com.ws06.dto.UserDto;

public class BankServiceImpl implements BankService {
	ArrayList<AccountDto> accountList;
	ArrayList<UserDto> userList;
	
	public BankServiceImpl() {
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
	@Override
	public ArrayList<AccountDto> getAccountList(int userSeq) { // 100 
		ArrayList<AccountDto> searchAccountDtoList =  new ArrayList<>();
		for(AccountDto account :accountList) {
				if(account.getUserSeq() == userSeq) {
					 //찾았다!!
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
	@Override
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
	@Override
	public ArrayList<AccountDto> getAccountList() {
		return accountList;
	}
	/**
	 * 4) 신규로, 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
       : Comparable Interface 를 이용한다.
       */
	@Override
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		ArrayList<AccountDto> shallowCopy = new ArrayList<>(accountList);
		Collections.sort(shallowCopy);
		
		return shallowCopy;
	}
	/**
	 * 5)  신규로, 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다. 
	 * 만약 사용자 일련 번호 같은면 잔액을 기준으로 내림차순
       : Comparator Interface 를 이용한다.
       */
	@Override
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		ArrayList<AccountDto> shallowCopy = new ArrayList<>(accountList);
		Collections.sort(shallowCopy, (e1, e2)->e1.getUserSeq()-e2.getUserSeq());
		//삼항식 구조, 조건식 ? 참 : 거짓
//		Collections.sort(shallowCopy, (e1, e2)->e1.getUserSeq()==e2.getUserSeq() ? 
//				e2.getBalance()-e1.getBalance(): e1.getUserSeq()-e2.getUserSeq());
		return shallowCopy;
	}

}
