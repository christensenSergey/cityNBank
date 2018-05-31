package cityNBank.service.interfaces;

import java.util.List;

import cityNBank.entities.Account;
import cityNBank.entities.Client;

public interface ClientService {

	public List<Client> findAll();

	public void save(Client client);

	List<Account> getAccounts(Long id);
}
