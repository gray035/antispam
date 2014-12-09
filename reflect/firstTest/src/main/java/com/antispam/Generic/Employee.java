package main.java.com.antispam.Generic;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by yangshenneng on 14/12/10.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name,double salary,int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double percent) {
        double raise = salary*percent / 100;
        salary += raise;
    }

    public boolean equals(Object object) {
        if(this == object)
            return true;

        if(object == null)
            return false;

        if(getClass() != object.getClass())
            return false;

        Employee other = (Employee) object;
        return (name.equals(other.name)) && (hireDay.equals(other.hireDay) && (salary==other.salary));
    }

    public int hashCode() {
        return this.hashCode();
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
