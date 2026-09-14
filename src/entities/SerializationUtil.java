/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
/**
 *
 * @author hp
 */

public class SerializationUtil {

    public static void serializeEmployees(String path, List<Employee> data) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(data);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees(String path) throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Employee>) ois.readObject();
        }
    }
}
