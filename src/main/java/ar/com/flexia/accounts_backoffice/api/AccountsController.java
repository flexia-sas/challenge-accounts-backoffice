package ar.com.flexia.accounts_backoffice.api;

import ar.com.flexia.accounts_backoffice.api.dto.NewAccount;
import ar.com.flexia.accounts_backoffice.api.dto.PasswordChange;
import ar.com.flexia.accounts_backoffice.application.ChangePasswordUseCase;
import ar.com.flexia.accounts_backoffice.application.CreateAccountUseCase;
import ar.com.flexia.accounts_backoffice.application.DeactivateAccountUseCase;
import ar.com.flexia.accounts_backoffice.application.ListAccountsUseCase;
import ar.com.flexia.accounts_backoffice.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	@Autowired
	private CreateAccountUseCase createAccountUseCase;
	@Autowired
	private DeactivateAccountUseCase deactivateAccountUseCase;
	@Autowired
	private ChangePasswordUseCase changePasswordUseCase;
	@Autowired
	private ListAccountsUseCase listAccountsUseCase;

	@GetMapping
	public List<Account> listAccounts(@RequestParam(required = false) boolean showInactive) {
		if (showInactive) {
			return listAccountsUseCase.listInactiveAccounts();
		}
		return listAccountsUseCase.listActiveAccounts();
	}

	@PostMapping
	public Long createAccount(@RequestBody NewAccount request) {
		var account = createAccountUseCase
				.createAccount(request.getName(), request.getEmail(), request.getPassword());
		return account.getId();
	}

	@DeleteMapping("/{id}")
	public void deactivateAccount(@PathVariable long id) {
		deactivateAccountUseCase.deactivateAccount(id);
	}

	@PutMapping("/{id}/password")
	public void changeAccountPassword(@PathVariable long id, @RequestBody PasswordChange request) {
		changePasswordUseCase.changePassword(id, request.getNewPassword(), request.getOldPassword());
	}
}
