package ca.soccer.domain;
public class Statistics {
    private Integer numberOfGoals;
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

