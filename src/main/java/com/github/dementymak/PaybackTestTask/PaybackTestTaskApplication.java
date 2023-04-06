package com.github.dementymak.PaybackTestTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class PaybackTestTaskApplication {
	private Checkerboard checkerboard = new Checkerboard(15);
	private int roundCount = 0;
	public static void main(String[] args) {
		SpringApplication.run(PaybackTestTaskApplication.class, args);

	}



}
