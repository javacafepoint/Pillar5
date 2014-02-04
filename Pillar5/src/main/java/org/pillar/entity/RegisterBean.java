package org.pillar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="Users")
public class RegisterBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@NotEmpty
	@NotNull
	@NumberFormat(pattern="##########")
	@Size(min=10, max=10, message="Mobile number should not be empty")
	private int mobile;
	
	@NotEmpty
	@Email(message="Email cannot be empty")
	private String email;
	
	private String gender;
	
	@NotEmpty(message="Select one from the list...")
	private String state;

	@NotEmpty(message="Select one from the below list...")
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
