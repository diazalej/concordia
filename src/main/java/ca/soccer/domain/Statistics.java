package ca.soccer.domain;

import javax.persistence.Column;

public class Statistics {
    @Column(name="numberOfGoals")
    private Integer numberOfGoals;

    @Column(name="numberOfBookings")
    private Integer numberOfBookings;

    public Statistics(Integer numberOfGoals, Integer numberOfBookings) {
        this.numberOfGoals = numberOfGoals;
        this.numberOfBookings = numberOfBookings;
    }
    public Integer getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(Integer numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public Integer getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(Integer numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }



}

