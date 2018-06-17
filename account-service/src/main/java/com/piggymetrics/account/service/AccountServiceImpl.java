package com.piggymetrics.account.service;

import static com.piggymetrics.account.domain.Currency.getDefault;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.piggymetrics.account.client.AuthServiceClient;
import com.piggymetrics.account.client.StatisticsServiceClient;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.repository.AccountRepository;
import com.piggymetrics.account.repository.ItemRepo;
import com.piggymetrics.account.repository.SaveingAccRepo;
import com.piggymetrics.account.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private StatisticsServiceClient statisticsClient;

	@Autowired
	private AuthServiceClient authClient;

	@Autowired
	private AccountRepository repository;

	@Autowired
	private SaveingAccRepo saveingRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepo itemRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account findByName(String accountName) {
		Assert.hasLength(accountName);
		return repository.findByName(accountName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account create(User user) {

		Account existing = repository.findByName(user.getUsername());

		if (existing == null) {
			System.out.println(user.getUsername() + " " + user.getPassword());
			// authClient.createUser(user);
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			// Saving saving = new Saving();
			// saving.setAmount(new BigDecimal(0));
			// saving.setCurrency(Currency.getDefault());
			// saving.setInterest(new BigDecimal(0));
			// saving.setDeposit(false);
			// saving.setCapitalization(false);

			Account account = new Account();
			account.setName(user.getUsername());
			account.setLastSeen(new Date());
			account.setNote("first Account");
			account.setSaving(saveingRepo
					.save(new Saving(new BigDecimal(0), getDefault().name(), new BigDecimal(0), false, false)));
			//
			repository.save(account);

			log.info("new account has been created: " + account.getName());
			return account;
		} else {
			// Assert.isNull(existing, "account already exists: " +
			// user.getUsername());
			return existing;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveChanges(String name, Account update) {
		Account account = repository.findByName(name);
		System.out.println(account.getId() + " " + account.getName() + " " + update.getNote());
		// Assert.notNull(account, "can't find account with name " + name);
		if (!update.getIncomes().isEmpty()) {
			update.getIncomes().stream().forEach(updates -> {
				updates.setPurchase(account);
				updates.setSelles(null);
			});
		}
		if (!update.getExpenses().isEmpty()) {
			update.getExpenses().stream().forEach(updates -> {
				updates.setPurchase(null);
				updates.setSelles(account);
			});
		}

		// itemRepo.save(update.getIncomes());
		account.setIncomes(update.getIncomes());
		account.setExpenses(update.getExpenses());
		// saveingRepo.save(update.getSaving())
		account.setSaving(saveingRepo.save(update.getSaving()));
		account.setNote(update.getNote());
		account.setLastSeen(new Date());

		repository.save(account);
		//
		// log.debug("account {} changes has been saved", name);
		//
		// statisticsClient.updateStatistics(name, account);
	}
}
