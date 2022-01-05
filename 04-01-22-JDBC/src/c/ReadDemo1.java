package c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDemo1 {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db2";
		String user = "root";
		String password = "1234";
		
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)){
			String sql = "select * from person";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				rs.next(); // move to first row of result set
				// id from column 1 - id
				int id = rs.getInt("id"); // instead of id also 1 (column)
				// name from column 2 - name
				String name = rs.getString("name"); // instead of name also 2 (column)
				// print
				System.out.println("id: " + id + ", name: " + name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
