package com.example.factapp;

public class CalculFactorielle {
    private int num;
    public CalculFactorielle(int num) {
        this.num = num;
    }
    public static int getFact(int num){
        int res = 1;
        for (int i = 1; i <= num; i++) {

            res*=i;
        }
        return res ;
    }

}
