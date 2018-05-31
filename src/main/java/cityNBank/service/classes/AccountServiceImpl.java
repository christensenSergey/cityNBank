package cityNBank.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cityNBank.entities.Account;
import cityNBank.repositories.AccountRepository;
import cityNBank.repositories.ClientRepository;
import cityNBank.service.interfaces.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public void save(Account account, Long clientId) {
		account.setClient(clientRepository.getOne(clientId));
		accountRepository.save(account);
	}

}
