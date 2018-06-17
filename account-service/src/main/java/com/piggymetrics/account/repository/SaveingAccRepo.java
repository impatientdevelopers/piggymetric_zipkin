package com.piggymetrics.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.piggymetrics.account.domain.Saving;

public interface SaveingAccRepo extends CrudRepository<Saving, Integer> {

}
