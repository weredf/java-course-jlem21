package d;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDemo2 {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db1";
		String user = "root";
		String password = "1234";

		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from book";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

//				rs.next(); // move to first row of result set
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int authorId = rs.getInt("author_id");
				Date publication = rs.getDate("publication_date");
				float price = rs.getFloat("price");
				// print
				System.out.println("id: " + id + ", title: " + title + ", author id: " + authorId
						+ ", publication date: " + publication + ", price: " + price);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
