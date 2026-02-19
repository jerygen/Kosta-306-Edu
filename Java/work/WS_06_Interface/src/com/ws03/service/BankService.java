package com.ws03.service;

import java.util.ArrayList;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;

public interface BankService {
	ArrayList<AccountDto> getAccountList(int userSeq);
	UserDto getUserDetail(int userSeq);
	ArrayList<AccountDto> getAccountList();
	ArrayList<AccountDto> getAccountListSortByBalance(); 
	ArrayList<AccountDto> getAccountListSortByUserSeq();
}
