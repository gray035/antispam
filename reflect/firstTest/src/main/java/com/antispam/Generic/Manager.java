package main.java.com.antispam.Generic;

/**
 * Created by yangshenneng on 14/12/10.
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name,double salary,int year,int month,int day) {
        super(name,salary,year,month,day);
        bonus = 0;
    }

    public double getBonus() {
        return this.bonus;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object object) {
        if(!super.equals(object))
            return false;
        Manager other = (Manager) object;
        return bonus == other.bonus;
    }

    public int hashCode() {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
