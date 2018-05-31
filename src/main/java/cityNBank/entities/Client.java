package cityNBank.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Simple JavaBean object that represents Clients
 * 
 * @author Sergey Christensen
 */

@Entity
@Table(name = "clients")
public class Client {

	public Client() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "age")
	private Integer age;

	@OneToMany(mappedBy = "client")
	private List<Account> accounts;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Account> getClientAccounts() {
		return accounts;
	}

	public void setClientAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
