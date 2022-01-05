package c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatementAndExecuteInsert {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "1234";
		// define an sql as String
		String sql1 = "create table person(id int, name varchar(25))";
		
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			// use the connection to get a Statement object
			Statement stmt = con.createStatement();
			// execute the sql
//			stmt.execute(sql1);
			// execute the sql - insert
/*
			for (int i = 201; i<=300; i++) {
				String sql2 = "insert into person values(" + i + ", 'p-" + i + "')";
				stmt.executeUpdate(sql2);
				System.out.println(sql2);
			}*/
			String sql3 = "update person set name = 'Yosi' where id = 205";
			stmt.executeUpdate(sql3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
