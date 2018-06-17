package com.piggymetrics.statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piggymetrics.statistics.domain.timeseries.DataPointId;

public interface DataPointIdRepo extends JpaRepository<DataPointId, Integer> {

}
