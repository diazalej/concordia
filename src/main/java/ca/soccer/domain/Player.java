package ca.soccer.domain;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Currency;

//@Component
@Entity
public class Player {
	@NotNull
	@Id
	@Column(name = "firstName")
	private String firstName;

	@NotNull
	@Column(name = "lastName")
	private String lastName;

	@NotNull
	@Column(name = "age")
	private Integer age;

	@NotNull
	@Column(name = "countryOfBirth")
	private String countryOfBirth;

	@NotNull
	@Column(name = "annualSalary")
	private BigDecimal annualSalary;

	@Transient
	private Position position;

	@Transient
	private Statistics statistics;

	public Player() {}

	public Player(String firstName, String lastName, Integer age, String countryOfBirth, BigDecimal annualSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.countryOfBirth = countryOfBirth;
		this.annualSalary = annualSalary;
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

	public Integer getAge() {

		return age;
	}

	public void setAge(Integer age) {

		this.age = age;
	}
	public String getCountryOfBirth() {

		return countryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {

		this.countryOfBirth = countryOfBirth;
	}

	public BigDecimal getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(BigDecimal annualSalary) {
		this.annualSalary = annualSalary;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==null) return false;
		if (!(obj instanceof Player)) return false;
		return this.getFirstName().equals(((Player)obj).getFirstName());
	}
}