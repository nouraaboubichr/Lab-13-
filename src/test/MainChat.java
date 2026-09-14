/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities1.ChatHistory;
import entities1.ChatMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class MainChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "chat.ser";

        // 1) Creation d'un historique de chat
        List<ChatMessage> history = new ArrayList<ChatMessage>();
        history.add(new ChatMessage("Youssef", "Salam tout le monde"));
        history.add(new ChatMessage("Fatima", "Wa alaykum as-salam"));
        history.add(new ChatMessage("Omar", "Comment ca va ?"));

        // 2) Sauvegarde
        try {
            ChatHistory.save(file, history);
            System.out.println("Historique sauvegarde dans " + file);

        } catch (IOException e) {
            System.err.println("Erreur sauvegarde : " + e.getMessage());
            return;
        }

        // 3) Chargement
        List<ChatMessage> loaded = null;

        try {
            loaded = ChatHistory.load(file);
            System.out.println("Historique charge :");

        } catch (IOException e) {
            System.err.println("Erreur chargement : " + e.getMessage());
            return;

        } catch (ClassNotFoundException e) {
            System.err.println("Classe introuvable : " + e.getMessage());
            return;
        }

        // 4) Affichage
        for (int i = 0; i < loaded.size(); i++) {
            ChatMessage msg = loaded.get(i);
            System.out.println("  [" + msg.getLength() + " chars] " + msg);
        }
    }
    
}
