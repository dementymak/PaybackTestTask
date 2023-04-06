package com.github.dementymak.PaybackTestTask;

import java.util.Random;
import com.github.dementymak.PaybackTestTask.Checkerboard;

public class Pointee {
    private int col;
    private int row;
    private Random rand = new Random();

    public void JumpPointee(Checkerboard checkerboard) {
        for (int i = 0; i < checkerboard.getSize(); i++) {
            for (int j = 0; j < checkerboard.getSize(); j++) {
                if (col == 0) {
                    int jumpcol = rand.nextInt(2);
                    col = i + jumpcol;
                }
                if(col == 14) {
                    int jumpcol = rand.nextInt(2) - 1;
                    col = i + jumpcol;
                }
                int jumpcol = rand.nextInt(3) - 1;
                col = i + jumpcol;
                if (row == 0) {
                    int jumprow = rand.nextInt(2);
                    col = i + jumprow;
                }
                if(row == 14) {
                    int jumprow = rand.nextInt(2) - 1;
                    col = i + jumprow;
                }
                int jumprow = rand.nextInt(3) - 1;
                row = j + jumprow;
            }
        }
    }
}
