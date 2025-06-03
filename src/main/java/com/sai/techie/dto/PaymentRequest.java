package com.sai.techie.dto;

import java.time.LocalDate;

public class PaymentRequest {
	private String transactionId;
	private String sourceAcc;
	private String destAcc;
	private double amount;
	private LocalDate txDate;
	
	public PaymentRequest() {
		
	}
	
	public PaymentRequest(String transactionId, String sourceAcc, String destAcc, double amount, LocalDate txDate) {
		super();
		this.transactionId = transactionId;
		this.sourceAcc = sourceAcc;
		this.destAcc = destAcc;
		this.amount = amount;
		this.txDate = txDate;
	}

	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getSourceAcc() {
		return sourceAcc;
	}
	public void setSourceAcc(String sourceAcc) {
		this.sourceAcc = sourceAcc;
	}
	public String getDestAcc() {
		return destAcc;
	}
	public void setDestAcc(String destAcc) {
		this.destAcc = destAcc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getTxDate() {
		return txDate;
	}
	public void setTxDate(LocalDate txDate) {
		this.txDate = txDate;
	}
	@Override
	public String toString() {
		return "PaymentRequest [transactionId=" + transactionId + ", sourceAcc=" + sourceAcc + ", destAcc=" + destAcc
				+ ", amount=" + amount + ", txDate=" + txDate + "]";
	}
	
}
