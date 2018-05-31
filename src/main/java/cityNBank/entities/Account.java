package cityNBank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Simple JavaBean object that represents Client accounts
 * 
 * @author Sergey Christensen
 */

@Entity
@Table(name = "accounts")
public class Account {

	public Account() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	// дописать комментарий про минусы дробных величин для данной цели, обосновать
	// выбор лонга
	@Column(name = "amount")
	private Long amount = 0L;

	@ManyToOne
	@JoinColumn(name = "clientid", nullable = false)
	private Client client;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
