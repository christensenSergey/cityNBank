package cityNBank.service.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cityNBank.entities.Account;
import cityNBank.entities.Transaction;
import cityNBank.repositories.AccountRepository;
import cityNBank.repositories.TransactionRepository;
import cityNBank.service.interfaces.TransactionService;
import cityNBank.utils.TransactionType;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	// Transaction processing logic
	@Override
	public void newTransaction(Transaction transaction) {
		TransactionType type = transaction.getType();
		Account sender = null;
		Account receiver = null;
		// Check if sender exist
		if (accountRepository.existsById(transaction.getSenderId())) {
			sender = accountRepository.getOne(transaction.getSenderId());
		}
		// Check if receiver exist
		if (accountRepository.existsById(transaction.getReceiverId())) {
			receiver = accountRepository.getOne(transaction.getReceiverId());
		}

		// in case of REFILL sender id = 0
		// in case of WRITEOFF sender id = 0
		switch (type) {
		case TRANSFER:
			// Check if sender and receiver exist
			if (sender != null && receiver != null && sender.getAmount() >= transaction.getAmount()) {
				sender.setAmount(sender.getAmount() - transaction.getAmount());
				receiver.setAmount(receiver.getAmount() + transaction.getAmount());
				accountRepository.save(sender);
				accountRepository.save(receiver);
			} else {
				transaction.setType(TransactionType.DENIED);
			}
			break;
		case REFILL:
			transaction.setSenderId(0L);
			if (receiver != null) {
				receiver.setAmount(receiver.getAmount() + transaction.getAmount());
				accountRepository.save(receiver);
			} else {
				transaction.setType(TransactionType.DENIED);
			}
			break;
		case WRITEOFF:
			transaction.setSenderId(0L);
			if (receiver != null && receiver.getAmount() >= transaction.getAmount()) {
				receiver.setAmount(receiver.getAmount() - transaction.getAmount());
				accountRepository.save(receiver);
			} else {
				transaction.setType(TransactionType.DENIED);
			}
			break;
		default:
			transaction.setType(TransactionType.DENIED);
			break;
		}
		// Filling transaction date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		transaction.setDate(dtf.format(localDate));
		transactionRepository.save(transaction);
	}

}
