package cityNBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cityNBank.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
