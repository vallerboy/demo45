package com.example.demo.models.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class CreditForm {
    @Min(value = 0)
    @Max(Integer.MAX_VALUE)
    private int salary;
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int costs;
    @Min(500)
    @Max(500000)
    private int credit;
    @NotBlank
    @Pattern(regexp = "[1-9][0-9]*")
    private String period;


    public CreditForm(int salary, int costs, int credit, String period) {
        this.salary = salary;
        this.costs = costs;
        this.credit = credit;
        this.period = period;
    }

    public CreditForm() {
        salary = 555;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "CreditForm{" +
                "salary=" + salary +
                ", costs=" + costs +
                ", credit=" + credit +
                ", period=" + period +
                '}';
    }
}
