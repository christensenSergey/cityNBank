package cityNBank.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cityNBank.entities.Account;
import cityNBank.entities.Client;
import cityNBank.repositories.ClientRepository;
import cityNBank.service.interfaces.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public void save(Client client) {
		clientRepository.save(client);
	}

	@Override
	public List<Account> getAccounts(Long id) {
		Client client = clientRepository.getOne(id);
		return client.getClientAccounts();
	}

}
