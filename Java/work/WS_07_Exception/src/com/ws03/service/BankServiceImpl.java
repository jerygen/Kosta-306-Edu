package com.ws03.service;

import java.util.ArrayList;
import java.util.Collections;

import com.ws03.dto.AccountDto;
import com.ws03.dto.InstallAccountDto;
import com.ws03.dto.LoanAccountDto;
import com.ws03.dto.SavingAccountDto;
import com.ws03.dto.UserDto;
import com.ws03.exception.BalanceLackException;
import com.ws03.exception.UserAccountNotFoundException;

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
	
	@Override
	public ArrayList<AccountDto> getAccountList(int userSeq) {
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
		
		ArrayList<AccountDto> searchAccountDtoList =  new ArrayList<>();
		
		for(AccountDto account :accountList) {
			if(account.getUserSeq() == userSeq) {
				searchAccountDtoList.add(account);	
			}
		}
		return searchAccountDtoList;
	}

	@Override
	public UserDto getUserDetail(int userSeq) {
		for(UserDto user:userList) {
			if(user.getUserSeq()==userSeq) {
				return user;
			}
		}
		return null;
	}

	@Override
	public ArrayList<AccountDto> getAccountList() {
		return (ArrayList<AccountDto>) accountList;
	}

	@Override
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		ArrayList<AccountDto> shallowCopy = new ArrayList<>(accountList);
		Collections.sort(shallowCopy, (e1, e2)->e1.getBalance()-e2.getBalance());
		
		return shallowCopy;
	}

	@Override
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		ArrayList<AccountDto> shallowCopy = new ArrayList<>(accountList);
		Collections.sort(shallowCopy);
		return shallowCopy;
	}

	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {
		for(AccountDto ac:accountList) {
			if(ac.getUserSeq()==userSeq && ac.getAccountSeq()==accountSeq) {
				return ac;
			}
		}
		throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다.");//for문을 다 돈 후에 예외처리
	}

	@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
			throws BalanceLackException, UserAccountNotFoundException {
		for(AccountDto ac:accountList) {
			if(ac.getUserSeq()==userSeq && ac.getAccountSeq()==accountSeq) {//일련번호, 계좌번호 비교
				int result = ac.getBalance()-amount;
				if(result>=0) {
					ac.setBalance(result);
					return result;
				}else {
					throw new BalanceLackException("잔액이 부족합니다.");
				}
			}
		}
		throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다.");//for문을 다 돈 후에 예외처리
	}

}
