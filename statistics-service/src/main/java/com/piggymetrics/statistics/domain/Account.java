package com.piggymetrics.statistics.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Document(collection = "accounts")
//@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private Date lastSeen;

	// @Valid
	// @JsonIgnore
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	private List<Item> incomes = new ArrayList<>();

	// @Valid
	// @Transient
	// @JsonIgnore
	@OneToMany(mappedBy = "selles", cascade = CascadeType.ALL)
	private List<Item> expenses = new ArrayList<>();

	// @Valid
	// @NotNull
	@ManyToOne(optional = true)
	private Saving saving = new Saving();

	// @Length(min = 0, max = 20_000)
	@Column(nullable = false, columnDefinition = "Text", length = 20000)
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public List<Item> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Item> incomes) {
		this.incomes = incomes;
	}

	public List<Item> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Item> expenses) {
		this.expenses = expenses;
	}

	public Saving getSaving() {
		return saving;
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
