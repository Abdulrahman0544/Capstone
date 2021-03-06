package com.saib.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.saib.models.Account;
import com.saib.models.Transactions;
import com.saib.repository.AccountRepository;
import com.saib.util.Results;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccount()
	{
		List<Account> list=accountRepository.findAll();
		return list;
	
		
	}
	
	public Account getAccountByAccountNumber(long accountNumber)
	{
		Optional<Account> optional=accountRepository.findById(accountNumber);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account with Account Number:"+accountNumber+"doesn't exist");
		}
		
	}
	
	
	public String addAccount(Account account)
	{
		String result="";
		Account storedAccount=accountRepository.save(account);
		if(storedAccount!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not created");
		}
		
		return result;
	}
	
	public String updateAccount(Account account, long accountNumber)
	{
		String result="";
		
		account.setAccountNumber(accountNumber);
		Account updatedAccount=accountRepository.save(account);
		
		if(updatedAccount!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
		
	}
	
	public String deleteAccount(long accountNumber)
	{
		String result="";
		try {
		accountRepository.deleteById(accountNumber);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
	}
	
	public List<Account> getAccountByType(String type)
	{
		List<Account> list=accountRepository.findAll();
		List<Account> accountsWithGivenType = null;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getAccountType() == type)
				accountsWithGivenType.add(list.get(i));
		}
		if(accountsWithGivenType.size() > 0) {
			return accountsWithGivenType;
		} 
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Accounts found with the given type");
		}
		
	}
	
	public List<Account> getAccountByStatus(String status)
	{
		List<Account> list=accountRepository.findAll();
		List<Account> accountsWithGivenStatus = null;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getStatus() == status)
				accountsWithGivenStatus.add(list.get(i));
		}
		if(accountsWithGivenStatus.size() > 0) {
			return accountsWithGivenStatus;
		} 
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Accounts found with the given status");
		}
		
	}

}
