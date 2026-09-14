/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hp
 */

public class ChatHistory {

    public static void save(String path, List<ChatMessage> history) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {

            oos.writeInt(history.size());

            for (int i = 0; i < history.size(); i++) {
                ChatMessage msg = history.get(i);
                msg.writeExternal(oos);
            }
        }
    }

    public static List<ChatMessage> load(String path) throws IOException, ClassNotFoundException {

        List<ChatMessage> history = new ArrayList<ChatMessage>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            int count = ois.readInt();

            for (int i = 0; i < count; i++) {
                ChatMessage msg = new ChatMessage();
                msg.readExternal(ois);
                history.add(msg);
            }
        }

        return history;
    }
}
