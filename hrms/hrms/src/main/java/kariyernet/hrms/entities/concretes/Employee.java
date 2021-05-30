package kariyernet.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="employee_id")
	private int employee_id;
	
	@Column(name="nationality_id")
	private String nationaltyId;
	
	@Column(name="last_name")
	private String lastName;
	@Column(name="e_mail")
	private String email;
	
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	@Column(name="password")
	private String password;
	
	private String rPassword;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String email, String nationaltyId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.nationaltyId = nationaltyId;
		this.password = password;
	}
}
