package com.example.demo.models;


import com.example.demo.models.forms.CreditForm;

import javax.persistence.*;
import java.sql.Date;
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
    private Date date;

    public CreditModel(int salary, int costs, int credit, int period, Date date) {
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
        date = new Date(Calendar.getInstance().getTimeInMillis());
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
