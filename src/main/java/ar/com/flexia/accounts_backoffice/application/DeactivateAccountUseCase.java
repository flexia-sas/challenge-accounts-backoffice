package ar.com.flexia.accounts_backoffice.application;

import ar.com.flexia.accounts_backoffice.domain.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * Use case for inactivating an account
 */
@Service
public class DeactivateAccountUseCase {
	private final AccountRepository accountRepository;

	public DeactivateAccountUseCase(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void deactivateAccount(long accountId) {
		var account = accountRepository.findById(accountId).orElseThrow();
		account.deactivate();
		accountRepository.save(account);
	}
}
