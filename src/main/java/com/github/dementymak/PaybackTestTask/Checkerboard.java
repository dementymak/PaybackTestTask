package com.github.dementymak.PaybackTestTask;

public class Checkerboard {
    private static int size;
    private static int round;
    public Coupon[][] coupons;
    public Pointee[][] pointees;

    public int getSize(){
        return size;
    }

    public Checkerboard(int size, int round) {
        this.size = size;
        this.round = round;
        coupons = new Coupon[size][size];
        pointees = new Pointee[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                coupons[i][j] = new Coupon(i , j);
                pointees[i][j] = new Pointee(i, j);
            }
        }
    }

}
