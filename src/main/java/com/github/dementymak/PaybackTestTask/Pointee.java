package com.github.dementymak.PaybackTestTask;

import java.util.Random;
import com.github.dementymak.PaybackTestTask.Checkerboard;

public class Pointee {
    Pointee(int col, int row){
        this.col = col;
        this.row = row;
    }
    private int col;
    private int row;
    private Random rand = new Random();

    public void JumpPointee(Checkerboard checkerboard) {



                if(this.getCol() > 0 && this.getCol() < 14) {
                    int jumpcol = rand.nextInt(3) - 1;
                    col = this.getCol() + jumpcol;
                }
                if (this.getCol() == 0) {
                    int jumpcol = rand.nextInt(2);
                    col = this.getCol() + jumpcol;
                }
        if(this.getCol() == 14) {
            int jumpcol = rand.nextInt(2) - 1;
            col = this.getCol() + jumpcol;
        }


                if(this.getRow() > 0 && this.getRow() < 14) {
                    int jumprow = rand.nextInt(3) - 1;
                    row = this.getRow() + jumprow;
                }
                if (this.getRow() == 0) {
                    int jumprow = rand.nextInt(2);
                    row = this.getRow() + jumprow;
                }
        if(this.getRow() == 14) {
            int jumprow = rand.nextInt(2) - 1;
            row = this.getRow() + jumprow;
        }

    }

    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
}
