package com.piggymetrics.statistics.domain.timeseries;

import com.piggymetrics.statistics.domain.Currency;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Represents daily time series data point containing current account state
 */
// @Document(collection = "datapoints")
@Entity
public class DataPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = true)
	private DataPointId pointId = new DataPointId();

	@Transient
	private Set<ItemMetric> incomes;

	@Transient
	private Set<ItemMetric> expenses;

	@Transient
	private Map<StatisticMetric, BigDecimal> statistics;

	@Transient
	private Map<Currency, BigDecimal> rates;

	public DataPoint() {
	}

	public DataPoint(DataPointId pointId, Set<ItemMetric> incomes, Set<ItemMetric> expenses,
			Map<StatisticMetric, BigDecimal> statistics, Map<Currency, BigDecimal> rates) {
		this.pointId = pointId;
		this.incomes = incomes;
		this.expenses = expenses;
		this.statistics = statistics;
		this.rates = rates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DataPointId getPointId() {
		return pointId;
	}

	public void setPointId(DataPointId pointId) {
		this.pointId = pointId;
	}

	public Set<ItemMetric> getIncomes() {
		return incomes;
	}

	public void setIncomes(Set<ItemMetric> incomes) {
		this.incomes = incomes;
	}

	public Set<ItemMetric> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<ItemMetric> expenses) {
		this.expenses = expenses;
	}

	public Map<StatisticMetric, BigDecimal> getStatistics() {
		return statistics;
	}

	public void setStatistics(Map<StatisticMetric, BigDecimal> statistics) {
		this.statistics = statistics;
	}

	public Map<Currency, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<Currency, BigDecimal> rates) {
		this.rates = rates;
	}

}
