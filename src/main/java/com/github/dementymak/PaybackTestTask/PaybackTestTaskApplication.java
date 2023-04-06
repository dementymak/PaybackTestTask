package com.github.dementymak.PaybackTestTask;

import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PaybackTestTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaybackTestTaskApplication.class, args);

		int checkboardSize = 15;
		int roundCount = 25;


		Checkerboard[] checkboards = new Checkerboard[roundCount];
		int[][] result = new int[checkboardSize][checkboardSize];



		int round = 0;

		for (round = 0; round < roundCount; round++) {
			Checkerboard checkerboard = new Checkerboard(checkboardSize, round);

			System.out.println(Arrays.deepToString(checkerboard.coupons));
			System.out.println(Arrays.deepToString(checkerboard.pointees));

			for (Pointee[] pointee : checkerboard.pointees) {
				System.out.println();
				for (Pointee point : pointee) {
					System.out.print(point.getRow());
					System.out.print(":");
					System.out.print(point.getCol());
					System.out.print("  ");
				}
			}

			for (Pointee[] pointee : checkerboard.pointees) {
				for (Pointee point : pointee) {
					point.JumpPointee(checkerboard);
				}
			}

			for (Pointee[] pointee : checkerboard.pointees) {

				System.out.println();
				for (Pointee point : pointee) {
					System.out.print(point.getRow());
					System.out.print(":");
					System.out.print(point.getCol());
					System.out.print("  ");
				}

			}

			checkboards[round] = checkerboard;

		}


		for (Checkerboard board : checkboards) {

			for (Pointee[] point : board.pointees) {

				System.out.println();
				for (Pointee poin : point) {

					result[poin.getRow()][poin.getCol()] = result[poin.getRow()][poin.getCol()]+1;


				}
			}

		}



		System.out.println("Count pointee per each coupon AFTER 25 ROUNDS:");
		for (int[] col2 : result) {

			System.out.println();
			for (int row2 : col2) {
				System.out.print(row2);
				System.out.print("  ");
			}

		}



		System.out.println("MAX COUPON");


		int maxInRow = 0;



		for(int i = 0; i < checkboardSize; i++){
			for(int j = 0; j < checkboardSize-1; j++){
				for(int k = 0; k < checkboardSize-1; k++){
					if(result[i][k]>result[i][k+1]){
						int temp = result[i][k];
						result[i][k] = result[i][k+1];
						result[i][k+1] = temp;
					}

				}
			}
		}

		for (int[] col2 : result) {

			System.out.println();
			for (int row2 : col2) {
				System.out.print(row2);
				System.out.print("  ");
			}

		}







	}



}
