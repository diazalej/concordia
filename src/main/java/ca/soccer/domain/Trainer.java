
package ca.soccer.domain;

import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;


@Component
public class Trainer {
    @NotNull
    @Id
    @Column(name="firstName")
    private String firstName;

    @NotNull
    @Column(name="lastName")
    private String lastName;

    @NotNull
    @Column(name="age")
    private Integer age;

    @NotNull
    @Column(name="annualSalary")
    private BigDecimal annualSalary;

    public Trainer() {}

    public Trainer(String firstName, String lastName, Integer age, BigDecimal annualSalary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if (!(obj instanceof Trainer)) return false;
        return this.getFirstName().equals(((Trainer)obj).getFirstName());
    }
}
