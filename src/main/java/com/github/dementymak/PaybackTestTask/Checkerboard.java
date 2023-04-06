package com.github.dementymak.PaybackTestTask;

public class Checkerboard {
    private static int size;
    public Coupon[][] coupons;
    public Pointee[][] pointees;

    public int getSize(){
        return size;
    }

    public Checkerboard(int size) {
        this.size = size;
        coupons = new Coupon[size][size];
        pointees = new Pointee[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                coupons[i][j] = new Coupon(0);
                pointees[i][j] = new Pointee();
            }
        }
    }

    public void runRound() {

    }


}
