package ar.com.flexia.accounts_backoffice.application;

import ar.com.flexia.accounts_backoffice.domain.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * Use case for changing an account password
 */
@Service
public class ChangePasswordUseCase {
	private final AccountRepository accountRepository;

	public ChangePasswordUseCase(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void changePassword(long accountId, String oldPass, String newPass) {
		var account = accountRepository.findById(accountId).orElseThrow();
		if (!account.getPassword().equals(oldPass)) {
			throw new IllegalArgumentException("Invalid password");
		}
		account.setPassword(newPass);
		accountRepository.save(account);
	}
}
