package cityNBank.service.interfaces;

import java.util.List;

import cityNBank.entities.Transaction;

public interface TransactionService {

	List<Transaction> findAll();

	public void newTransaction(Transaction transaction);

}
