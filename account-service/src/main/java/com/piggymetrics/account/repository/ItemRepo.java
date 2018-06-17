package com.piggymetrics.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piggymetrics.account.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
