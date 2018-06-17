package com.piggymetrics.statistics.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Saving {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @NotNull
	@Column(nullable = false)
	private BigDecimal amount;

	// @NotNull
	// @Transient
	private String currency;

	// @NotNull
	@Column(nullable = false)
	private BigDecimal interest;

	// @NotNull
	@Column(nullable = false)
	private Boolean deposit;

	// @NotNull
	@Column(nullable = false)
	private Boolean capitalization;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saving")
	private List<Account> account = new ArrayList<>();

	public Saving() {
	}

	public Saving(BigDecimal amount, String currency, BigDecimal interest, Boolean deposit, Boolean capitalization) {
		this.amount = amount;
		this.currency = currency;
		this.interest = interest;
		this.deposit = deposit;
		this.capitalization = capitalization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public Boolean getDeposit() {
		return deposit;
	}

	public void setDeposit(Boolean deposit) {
		this.deposit = deposit;
	}

	public Boolean getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(Boolean capitalization) {
		this.capitalization = capitalization;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

}
