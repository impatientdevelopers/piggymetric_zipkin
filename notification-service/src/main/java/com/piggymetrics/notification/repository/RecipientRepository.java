package com.piggymetrics.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piggymetrics.notification.domain.Recipient;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Integer> {

	Recipient findByAccountName(String name);

	// @Query("{ $and: [ {scheduledNotifications.BACKUP.active: true }, {$where:
	// 'this.scheduledNotifications.BACKUP.lastNotified < "
	// + "new Date(new Date().setDate(new Date().getDate() -
	// this.scheduledNotifications.BACKUP.frequency ))' }] }")
	// List<Recipient> findReadyForBackup();

	// @Query("{ $and: [ {scheduledNotifications.REMIND.active: true },
	// {$where:'this.scheduledNotifications.REMIND.lastNotified<"
	// + "new Date(new Date().setDate(new Date().getDate()
	// -this.scheduledNotifications.REMIND.frequency))' }]}")
	// List<Recipient> findReadyForRemind();

}
