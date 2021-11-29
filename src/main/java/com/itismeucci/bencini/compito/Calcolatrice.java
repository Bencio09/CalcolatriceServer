package com.itismeucci.bencini.compito;

import java.io.IOException;

public class Calcolatrice {
    int val1 = 0;
    int val2 = 0;
    char segno;
    int ris;
    Server server;

    public Calcolatrice(String val1, String val2, String segno) {
        this.val1 = toInt(val1);
        this.val2 = toInt(val2);
        this.segno = toChar(segno);
        server = new Server();
    }

    public int toInt(String val){
        return Integer.parseInt(val);
    }

    public char toChar(String val){
        return val.charAt(0);
    }

    public int somma(int val1, int val2) {
        return val1 + val2;
    }

    public int sottrazione(int val1, int val2) {
        return val1 - val2;
    }

    public int moltiplicazione(int val1, int val2) {
        return val1 * val2;
    }

    public int divisione(int val1, int val2) {
        return val1 / val2;
    }

    public void cheOperazione() {
        switch (segno) {
            case '+':
                ris = somma(val1, val2);
                break;
            case '-':
                ris = sottrazione(val1, val2);
                break;
            case '*':
                ris = moltiplicazione(val1, val2);
                break;
            case '/':
                ris = divisione(val1, val2);
                break;
            default:
                try {
                    server.outVersoClient.writeBytes("S -> Quello che hai messo non è un segno che posso capire\n");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
        }
        try {
            server.outVersoClient.writeBytes("S -> Il risultato dell'operazione richiesta è " + ris +"\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
