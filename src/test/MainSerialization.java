/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Employee;
import entities.SerializationUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hp
 */
public class MainSerialization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filePath = "employees.ser";

        
        List<Employee> staff = new ArrayList<Employee>();
        staff.add(new Employee(1, "Youssef", 3000.0, "pwdYoussef"));
        staff.add(new Employee(2, "Fatima", 3500.5, "pwdFatima"));
        staff.add(new Employee(3, "Omar", 2800.75, "pwdOmar"));

       
        try {
            SerializationUtil.serializeEmployees(filePath, staff);
            System.out.println("-> Serialisation reussie dans " + filePath);

        } catch (IOException e) {
            System.err.println("Erreur de serialisation : " + e.getMessage());
            return;
        }

        
        List<Employee> loaded = null;

        try {
            loaded = SerializationUtil.deserializeEmployees(filePath);
            System.out.println("-> Deserialisation reussie, objets restaures :");

        } catch (IOException e) {
            System.err.println("Erreur de deserialisation : " + e.getMessage());
            return;

        } catch (ClassNotFoundException e) {
            System.err.println("Classe introuvable : " + e.getMessage());
            return;
        }

       
        for (int i = 0; i < loaded.size(); i++) {
            System.out.println("  " + loaded.get(i));
        }

        
        System.out.println();
        System.out.println("Note : le champ 'password' est transient, il n'a pas ete enregistre -> null.");
    }
    
}
