/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
/**
 *
 * @author hp
 */

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double salary;
    private transient String password;

    public Employee(int id, String name, double salary, String password) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        String pwd = (password == null ? "null" : password);
        return "Employee[id=" + id + ", name=" + name + ", salary=" + salary + ", password=" + pwd + "]";
    }
}
