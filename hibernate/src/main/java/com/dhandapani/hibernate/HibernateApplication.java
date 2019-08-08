package com.dhandapani.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
		String url = "jdbc:mysql://localhost:3306/hibernate";
		String username = "root";
		String password = "root";
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successful");
			conn.close();
		} catch (Exception ex) {
			System.out.println("Exception occured" + ex);
		}
	}

}
