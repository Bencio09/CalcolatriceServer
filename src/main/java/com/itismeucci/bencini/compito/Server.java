package com.itismeucci.bencini.compito;

import java.io.*;
import java.net.*;

public class Server {
    ServerSocket server = null;
    Socket client = null;
    String val1 = null;
    String val2 = null;
    String segno = null;
    String cheFai = null;
    String Risultato = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    Calcolatrice calcolatrice = null;

    public Socket attendi() {
        try {
            System.out.println("S -> Server partito in esecuzione");

            server = new ServerSocket(4335);

            client = server.accept();

            server.close();

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server!");
            System.exit(1);
        }
        return client;
    }

    public void comunica(){
        try {
            System.out.println("Benvenuto io sono un server calcolatrice!\n");
            do{
                System.out.println("S -> Inserisci il primo valore\n");
                val1 = inDalClient.readLine();
                System.out.println("S -> Inserisci il secondo valore\n");
                val2 = inDalClient.readLine();
                System.out.println("S -> Inserisci il segno (+,-,*,/)\n");
                segno = inDalClient.readLine();
                calcolatrice = new Calcolatrice(val1, val2, segno);
                System.out.println("S -> Ti servo ancora? Y/N\n");
                cheFai = inDalClient.readLine();
            }while(cheFai.equalsIgnoreCase("Y"));
            close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void close(){
        try {
            inDalClient.close();
            outVersoClient.close();
            client.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
