package com.saib.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.saib.models.Transactions;
import com.saib.repository.AccountRepository;
import com.saib.repository.TransactionRepository;
import com.saib.util.Results;

@Service
public class TransactionsService {
	
	@Autowired
	TransactionRepository transactionRepository;

	public List<Transactions> getAllTransactions()
	{
		List<Transactions> list=transactionRepository.findAll();
		return list;
	
		
	}
	
	public Transactions getTransactionByTransactionId(long transactionId)
	{
		Optional<Transactions> optional=transactionRepository.findById(transactionId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction with Transaction id:"+transactionId+"doesn't exist");
		}
		
	}
	
	
	public String addTransaction(Transactions transaction)
	{
		String result="";
		Transactions storedAccount=transactionRepository.save(transaction);
		if(storedAccount!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not created");
		}
		
		return result;
	}
	
	public String updateTransaction(Transactions transaction, long transactionId)
	{
		String result="";
		
		transaction.setTransactionId(transactionId);
		Transactions updatedAccount=transactionRepository.save(transaction);
		
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
	
	public String deleteTransaction(long transactionID)
	{
		String result="";
		try {
		transactionRepository.deleteById(transactionID);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}				
	}
	
	public List<Transactions> getTransactionByDate(LocalDateTime date)
	{
		List<Transactions> list=transactionRepository.findAll();
		List<Transactions> transactionWithGivenDate = null;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getDate() == date)
				transactionWithGivenDate.add(list.get(i));
		}
		if(transactionWithGivenDate.size() > 0) {
			return transactionWithGivenDate;
		} 
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No transactions found in the given date");
		}
		
	}
	
	public List<Transactions> getAllTransactionsMadeByUser(String userName)
	{
		List<Transactions> Transactionlist = transactionRepository.findAll();
		List<Transactions> transactionsForUuser = null;
		
		for(int i = 0; i < Transactionlist.size(); i++) {
			
			if(Transactionlist.get(i).getFromAccountName() == userName)
				transactionsForUuser.add(Transactionlist.get(i));
		}
		
		if(transactionsForUuser.size() > 0) {
			return transactionsForUuser;
		} 
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No transactions found with the given user name");
		}
		
	}

	public List<Transactions> getAllTransactionsReceivedByUser(String userName)
	{
		List<Transactions> Transactionlist = transactionRepository.findAll();
		List<Transactions> transactionsForUuser = null;
		
		for(int i = 0; i < Transactionlist.size(); i++) {
			
			if(Transactionlist.get(i).getToAccountName() == userName)
				transactionsForUuser.add(Transactionlist.get(i));
		}
		
		if(transactionsForUuser.size() > 0) {
			return transactionsForUuser;
		} 
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No transactions found with the given user name");
		}
		
	}
}
