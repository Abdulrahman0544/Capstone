package com.saib.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
	@Id
	@Column(name="transaction-id")
	private long transactionId;
	
	@Column(name="from-account")
	private long fromAccount;
	
	@Column(name="to-account")
	private long toAccount;
	
	@Column(name="from-account-Name")
	private String fromAccountName;
	
	@Column(name="to-account-Name")
	private String toAccountName;
	
	@Column(name="same-Bank-Transaction")
	private String sameBankTransaction;
	
	@Column(name="other-Bank")
	private String otherBank;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@Column(name="time")
	private LocalDateTime time;

	@Column(name="transaction-Type")
	private String transactionType;
	
	@Column(name="status")
	private String status;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(long transactionId, long fromAccount, long toAccount, String fromAccountName, String toAccountName, String sameBankTransaction,
			String otherBank, double amount, LocalDateTime date, LocalDateTime time,
			String transactionType, String status) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.fromAccountName = fromAccountName;
		this.toAccountName = toAccountName;
		this.sameBankTransaction = sameBankTransaction;
		this.otherBank = otherBank;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.transactionType = transactionType;
		this.status = status;
	}


	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public String getFromAccountName() {
		return fromAccountName;
	}

	public void setFromAccountName(String fromAccountName) {
		this.fromAccountName = fromAccountName;
	}

	public String getToAccountName() {
		return toAccountName;
	}

	public void setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
	}

	public String getSameBankTransaction() {
		return sameBankTransaction;
	}

	public void setSameBankTransaction(String sameBankTransaction) {
		this.sameBankTransaction = sameBankTransaction;
	}

	public String getOtherBank() {
		return otherBank;
	}

	public void setOtherBank(String otherBank) {
		this.otherBank = otherBank;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", fromAccountName=" + fromAccountName
				+ ", toAccountName=" + toAccountName + ", sameBankTransaction=" + sameBankTransaction + ", otherBank=" + otherBank + ", amount=" + amount
				+ ", date=" + date + ", time=" + time + ", transactionType=" + transactionType
				+ ", status=" + status + "]";
	}
	
	

	
	
	
	
}
