package cityNBank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cityNBank.utils.TransactionType;

/**
 * Simple JavaBean object that represents Client transactions
 * 
 * @author Sergey Christensen
 */

@Entity
@Table(name = "transactions")
public class Transaction {

	public Transaction() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "senderid")
	private Long senderId;

	@NotNull
	@Column(name = "receiverid")
	private Long receiverId;

	@NotNull
	@Column(name = "amount")
	private Long amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TransactionType type;

	@NotNull
	@Column(name = "date")
	private String date;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
