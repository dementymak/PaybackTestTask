package com.github.dementymak.PaybackTestTask;

import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class PaybackTestTaskApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PaybackTestTaskApplication.class, args);
		int checkboardSize = 15;

		System.out.println("Enter round count: 1-100");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int roundCount = Integer.parseInt(reader.readLine());


		Checkerboard[] checkboards = new Checkerboard[roundCount];
		int[][] result = new int[checkboardSize][checkboardSize];



		int round = 0;

		for (round = 0; round < roundCount; round++) {
			Checkerboard checkerboard = new Checkerboard(checkboardSize, round);

			System.out.println(Arrays.deepToString(checkerboard.coupons));
			System.out.println(Arrays.deepToString(checkerboard.pointees));
			System.out.println();
			System.out.println("pointees");
			System.out.println("round number: " + round);

			for (Pointee[] pointee : checkerboard.pointees) {
				System.out.println();
				for (Pointee point : pointee) {
					System.out.print(point.getRow());
					System.out.print(":");
					System.out.print(point.getCol());
					System.out.print("  ");
				}
			}
			/*Function jumping pointees*/
			for (Pointee[] pointee : checkerboard.pointees) {
				for (Pointee point : pointee) {
					point.JumpPointee(checkerboard);
				}
			}
			/*Show coordinats pointees after jumping*/
			System.out.println();
			System.out.println();
			System.out.println("pointees after jumping");
			System.out.println("round number: " + round);

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

		/*counting pointees on coupons*/
		for (Checkerboard board : checkboards) {
			for (Pointee[] point : board.pointees) {
				for (Pointee poin : point) {
					result[poin.getRow()][poin.getCol()] = result[poin.getRow()][poin.getCol()]+1;
				}
			}
		}


		/*show Count pointee per each coupon*/
		System.out.println();
		System.out.println();
		System.out.println("Count pointee per each coupon AFTER 25 ROUNDS:");
		for (int[] col2 : result) {

			System.out.println();
			for (int row2 : col2) {
				System.out.print(row2);
				System.out.print("  ");
			}

		}


		/*calculate and show the coupon(s) with the highest number of points.*/
		System.out.println();
		System.out.println();
		System.out.println("MAX COUPON");
		System.out.println();

		int max = result[0][0];
		List<String> coordinates = new ArrayList<>(); // Список координат найбільшого елемента

		// Перебираємо всі елементи масиву та знаходимо максимальний
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (result[i][j] > max) {
					max = result[i][j];
				}
			}
		}

		// add coordinats
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (result[i][j] == max) {
					coordinates.add("(" + i + ", " + j + ")");
				}
			}
		}

		// show result
		System.out.println("max count coupon: " + max);
		System.out.println("coordinats of max count coupon(s): " + String.join(", ", coordinates));
		if(round == 25 || round == 50 || round ==100)
			System.out.println("You can exchange your points for coupons");
	}
}
