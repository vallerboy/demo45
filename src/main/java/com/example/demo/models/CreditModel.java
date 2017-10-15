package com.example.demo.models;


import com.example.demo.models.forms.CreditForm;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "credit")
public class CreditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int salary;
    private int costs;
    private int credit;
    //@Column(name = "asdasd")
    private int period;
    private LocalDateTime date;

    public CreditModel(int salary, int costs, int credit, int period, LocalDateTime date) {
        this.salary = salary;
        this.costs = costs;
        this.credit = credit;
        this.period = period;
        this.date = date;
    }

    public CreditModel() {
    }

    public CreditModel(CreditForm form){
        salary = form.getSalary();
        costs = form.getCosts();
        credit = form.getCredit();
        period = Integer.parseInt(form.getPeriod());
        date = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CreditModel{" +
                "id=" + id +
                ", salary=" + salary +
                ", costs=" + costs +
                ", credit=" + credit +
                ", period=" + period +
                ", date=" + date +
                '}';
    }
}
