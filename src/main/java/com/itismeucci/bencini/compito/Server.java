package com.itismeucci.bencini.compito;

import java.io.*;
import java.net.*;

public class Server {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    Calcolatrice calcolatrice = null;

    public Socket attendi(){
        try{
            System.out.println("1 Server partito in esecuzione");

            server = new ServerSocket(4335);

            client = server.accept();

            server.close();

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server!");
            System.exit(1);
        }
        return client;
    }
}
