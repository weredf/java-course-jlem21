package a.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/db3?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password = "1234";

	public void create() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "create table product(id int primary key auto_increment, name varchar(25), price float)";
			Statement stmt = con.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Product product) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "insert into product values(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setFloat(3, product.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("save person failed", e);
		}
	}
	
	public Product get(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from product where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3));
				return p;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("read product failed", e);
		}
	}
	
	public void update(Product product) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "update product set name = ?, price = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setFloat(2, product.getPrice());
			pstmt.setInt(3, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("update product failed", e);
		}
	}
	
	public void delete(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from product where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("delete product " + id + " failed - not found");
			}
		} catch (SQLException e) {
			throw new RuntimeException("delete product failed", e);
		}
	}
}
