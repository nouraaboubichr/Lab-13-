/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.Instant;

/**
 *
 * @author hp
 */


public class ChatMessage implements Externalizable {

    private static final int FORMAT_VERSION = 1;

    private String user;
    private String message;
    private Instant timestamp;
    private transient int length;

    // Constructeur vide obligatoire pour Externalizable
    public ChatMessage() {
    }

    public ChatMessage(String user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = Instant.now();
        this.length = message.length();
    }

    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(FORMAT_VERSION);
        out.writeUTF(user);
        out.writeUTF(message);
        out.writeLong(timestamp.toEpochMilli());
        // length est derive de message, on ne l'ecrit pas
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        int version = in.readInt();

        if (version != FORMAT_VERSION) {
            throw new IOException("Version de format inconnue : " + version);
        }

        user = in.readUTF();
        message = in.readUTF();
        timestamp = Instant.ofEpochMilli(in.readLong());
        length = message.length();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return timestamp + " [" + user + "]: " + message;
    }
}
