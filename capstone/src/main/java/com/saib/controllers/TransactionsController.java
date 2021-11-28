package com.saib.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saib.config.ApiSuccessPayload;
import com.saib.models.Account;
import com.saib.models.Transactions;
import com.saib.services.TransactionsService;
import com.saib.util.Results;

@RestController
public class TransactionsController {
	
	/*
	 *  GET - /transactions - Get me all transactions 
	 *  GET - /transactions/transactionsid - Get me details for a single transaction 
	 *  POST - /transactions - Creating a new transaction 
	 *  PUT - /transactions/transactionsid - Updating an existing transaction 
	 *  DELETE -/transactions/transactionsid - for deleting a transaction from db
	 *  GET -/transactions/{date} - Get a transaction with a specified date
	 *  GET -/transactions/{fromAccountName} - Get all transactions made by a specified user
	 *  GET -/transactions/{toAccountName} - Get all transactions received by a specified user
	 */
	
	@Autowired
	TransactionsService transactionService;
	
	
	@GetMapping("/transactions")
	public ResponseEntity<ApiSuccessPayload> getAllTransactions()
	{
		List<Transactions> list=transactionService.getAllTransactions();
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transactions Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	
	@GetMapping("/transactions/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByTransactionId(@PathVariable long transactionId)
	{
		Transactions transactions=transactionService.getTransactionByTransactionId(transactionId);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(transactions, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<ApiSuccessPayload> addTransaction(@RequestBody Transactions transaction)
	{
		ResponseEntity<ApiSuccessPayload> response=null;
		System.out.println(transaction);
		String result=transactionService.addTransaction(transaction);
		if(result.equalsIgnoreCase(Results.SUCCESS))
		{
			ApiSuccessPayload payload=ApiSuccessPayload.build(result, "Transaction created successfully", HttpStatus.CREATED);
			response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.CREATED);
		}
		
		return response;
	
	}
	
	@PutMapping("/transactions/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> updateAccount(@RequestBody Transactions transaction, @PathVariable long transactionId)
	{
		String result=transactionService.updateTransaction(transaction, transactionId);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/transactions/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> deleteTransaction(@PathVariable long transactionId)
	{
		String result=transactionService.deleteTransaction(transactionId);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}

	@GetMapping("/transactions/{date}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByDate(@PathVariable LocalDateTime date)
	{
		List<Transactions> list=transactionService.getTransactionByDate(date);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Success", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/transactions/{fromAccountName}")
	public ResponseEntity<ApiSuccessPayload> getAllTransactionsMadeByUser(@PathVariable String userName)
	{
		List<Transactions> list=transactionService.getAllTransactionsMadeByUser(userName);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Success", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/transactions/{toAccountName}")
	public ResponseEntity<ApiSuccessPayload> getAllTransactionsReceivedByUser(@PathVariable String userName)
	{
		List<Transactions> list=transactionService.getAllTransactionsReceivedByUser(userName);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Success", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	

}
