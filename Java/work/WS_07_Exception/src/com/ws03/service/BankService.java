package com.ws03.service;

import java.util.ArrayList;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;
import com.ws03.exception.BalanceLackException;
import com.ws03.exception.UserAccountNotFoundException;

public interface BankService {
	ArrayList<AccountDto> getAccountList(int userSeq);
	UserDto getUserDetail(int userSeq);
	ArrayList<AccountDto> getAccountList();
	ArrayList<AccountDto> getAccountListSortByBalance(); 
	ArrayList<AccountDto> getAccountListSortByUserSeq();
	AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException;
	int withdraw(int userSeq, int accountSeq, int amount) throws BalanceLackException, UserAccountNotFoundException; 
}
