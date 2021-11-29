package com.itismeucci.bencini.compito;

public class Calcolatrice {
    int val1 = 0;
    int val2 = 0;

    public Calcolatrice(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public int somma(int val1, int val2){
        return val1+val2;
    }

    public int sottrazione(int val1, int val2){
        return val1-val2;
    }

    public int moltiplicazione(int val1, int val2){
        return val1*val2;
    }

    public int divisione(int val1, int val2){
        return val1/val2;
    }
}
