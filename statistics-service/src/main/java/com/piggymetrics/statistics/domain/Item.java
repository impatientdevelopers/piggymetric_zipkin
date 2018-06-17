package com.piggymetrics.statistics.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @NotNull
	@Column(nullable = false, length = 100)
	private String title;

	// @NotNull
	@Column(nullable = false)
	private BigDecimal amount;

	// @NotNull
	// @Transient
	private String currency;

	// @NotNull
	// @Transient
	private String period;

	// @NotNull
	@Column(nullable = false)
	private String icon;

	@JsonIgnore
	@ManyToOne(optional = true)
	private Account purchase = new Account();

	@JsonIgnore
	@ManyToOne(optional = true)
	private Account selles = new Account();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getPurchase() {
		return purchase;
	}

	public void setPurchase(Account purchase) {
		this.purchase = purchase;
	}

	public Account getSelles() {
		return selles;
	}

	public void setSelles(Account selles) {
		this.selles = selles;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
