package jm.model;

import java.util.Currency;

public class Money {
	private Currency currency;
	private Long amount;
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Money(Long amount) {
		this.currency = Currency.getInstance("USD");
		this.amount = amount;
	}
	public Money() {
		this.currency = Currency.getInstance("USD");
		this.amount = 0L;
	}
	
	
}