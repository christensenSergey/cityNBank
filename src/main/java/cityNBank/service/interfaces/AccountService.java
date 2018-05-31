package cityNBank.service.interfaces;

import java.util.List;

import cityNBank.entities.Account;

public interface AccountService {

	public List<Account> findAll();

	public void save(Account account, Long clientId);

}
