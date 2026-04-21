package org.pluralsight;

public class Employee {
    private int id;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int id, String name, double hoursWorked, double payRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // getters and setters for the above

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // method to calculate gross pay in Main
    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}
