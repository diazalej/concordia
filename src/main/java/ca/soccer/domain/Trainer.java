
package ca.soccer.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

@Component
public class Trainer {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<Team> previousTeamList = new LinkedList<Team>();
    private BigDecimal annualSalary;

    public Trainer() {}

    public Trainer(String firstName, String lastName, Integer age, List<Team> previousTeamList, BigDecimal annualSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.previousTeamList = previousTeamList;
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

    public List<Team> getPreviousTeamList() {
        return previousTeamList;
    }

    public void setPreviousTeamList(List<Team> previousTeamList) {
        this.previousTeamList = previousTeamList;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }
}
