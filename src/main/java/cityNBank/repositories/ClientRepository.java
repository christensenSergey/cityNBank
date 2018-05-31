package cityNBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cityNBank.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}