package com.ws07.service;

import java.util.ArrayList;
import java.util.Collections;

import com.ws07.dto.AccountDto;
import com.ws07.dto.InstallAccountDto;
import com.ws07.dto.LoanAccountDto;
import com.ws07.dto.SavingAccountDto;
import com.ws07.dto.UserDto;
import com.ws07.exception.BalanceLackException;
import com.ws07.exception.UserAccountNotFoundException;

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
		return (ArrayList<AccountDto>) accountList;
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
		//Collections.sort(shallowCopy, (e1, e2)->e1.getUserSeq()-e2.getUserSeq());
		//삼항식 구조, 조건식 ? 참 : 거짓
		Collections.sort(shallowCopy, (e1, e2)->e1.getUserSeq()==e2.getUserSeq() ? 
				e2.getBalance()-e1.getBalance(): e1.getUserSeq()-e2.getUserSeq());
		return shallowCopy;
	}
	/**
	 * 고객의 일련번호와 계좌 일련 번호를 입력받아 계좌 정보를 리턴한다.
	 * 이 때 일치하는 계좌가 없을 경우 UserAccountNotFoundException 을 발생시키고
	 * 이 요청을 수행하는 코드에서 처리한다.*/
	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {
		for(AccountDto ac:accountList) {
			if(ac.getUserSeq()==userSeq && ac.getAccountSeq()==accountSeq) {
				return ac;
			}
		}
		throw new UserAccountNotFoundException();//for문을 다 돈 후에 예외처리, 호출한 쪽에서 try-catch로 예외 처리
	}
	/**
	 * 고객번호와 계좌번호를 입력받아 계좌를 찾고 입력받은 금액을 잔액에서 출금한다.
	 * 이 떄 일치하는 계좌가 없을 경우 UserAccountNotFoundException 을 발생시키고 
	 * 이 요청을 수행하는 코드에서 처리하고, 
	 * 출금할 금액 보다 잔액이 부족할 경우 BalanceLackException 을 발생시키고
	 * 이 요청을 수행하는 코드에서 처리한다. */
	/*@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
			throws BalanceLackException, UserAccountNotFoundException {
		for(AccountDto ac:accountList) {
			if(ac.getUserSeq()==userSeq && ac.getAccountSeq()==accountSeq) {//일련번호, 계좌번호 비교
				int result = ac.getBalance()-amount;
				if(result>=0) {
					ac.setBalance(result);
					return result;
				}else {
					throw new BalanceLackException();
				}
			}
		}
		throw new UserAccountNotFoundException();//for문을 다 돈 후에 예외처리
	}*/
	
	@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
			throws BalanceLackException, UserAccountNotFoundException {//위에 이미 만들어 놓은 메소드를 활용하기 
		
		AccountDto dto = this.getUserAccount(userSeq,accountSeq);
		
		if(dto.getBalance() < 0) {
			throw new BalanceLackException();
		}
		dto.setBalance(dto.getBalance()-amount);
		return dto.getAccountSeq();
	}

}
