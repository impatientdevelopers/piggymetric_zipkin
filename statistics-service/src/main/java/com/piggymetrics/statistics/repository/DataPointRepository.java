package com.piggymetrics.statistics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piggymetrics.statistics.domain.timeseries.DataPoint;

@Repository
public interface DataPointRepository extends CrudRepository<DataPoint, Integer> {

	List<DataPoint> findByPointIdAccount(String account);

}
