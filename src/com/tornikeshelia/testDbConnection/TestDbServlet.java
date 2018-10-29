package com.tornikeshelia.testDbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup connection variables
		String user = "shelo";
		String pass = "kandakeba";
		
		String jdbcUrl = "jdbc:mysql://localhost:3308/db_test_connection?allowPublicKeyRetrieval=true&useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection to the database
		try {
			PrintWriter out = response.getWriter();
			
			System.out.println("\nConnecting to database: " + jdbcUrl);
			out.println("\nConnecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("\nconnection successful!!");
			out.println("\nconnection successful!!");
			
			myConn.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
	}

}
