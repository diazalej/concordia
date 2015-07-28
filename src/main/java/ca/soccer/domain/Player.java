package ca.soccer.domain;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;

@Component
public class Player {
	private String firstName;
	private String lastName;
	private Integer age;
	private String countryOfBirth;
	private BigDecimal annualSalary;
	private Position position;
	private Statistics statistics;


	public Player(String firstName, String lastName, Integer age, String countryOfBirth, BigDecimal annualSalary, Position position, Statistics statistics) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.countryOfBirth = countryOfBirth;
		this.annualSalary = annualSalary;
		this.position = position;
		this.statistics = statistics;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
}