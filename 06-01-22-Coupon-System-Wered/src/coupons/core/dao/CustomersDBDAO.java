package coupons.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class CustomersDBDAO implements CustomersDAO{
	
	private ConnectionPool connectionPool;

	@Override
	public boolean isCustomerExists(String email, String password) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers where email = ? and password = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public boolean isCustomerExists(int customerId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}
	
	@Override
	public int addCustomer(Customer customer) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "insert into customers values(0, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			customer.setId(id);
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("addCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "update customers set first_name = ?, last_name = ?, email = ? , password = ? where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemException("updateCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public void deleteCustomer(int customerId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "delete from customers where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("deleteCustomer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	
	@Override
	public boolean isCustomerCouponPurchaseExists(int customerId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers_vs_coupons where customer_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCustomerExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}
	
	@Override
	public void deleteCustomerCouponPurchase(int customerId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "delete from customers_vs_coupons where customer_id =?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("deleteCustomerCouponPurchase " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCustomerCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Customer> getAllCustomers() throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers";
		try (PreparedStatement pstmt = c.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Customer> customers = new ArrayList<>();
			while (rs.next()) {
				Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				customers.add(cus);
			}
			return customers;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCustomers failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return cus;
			} else {
				throw new CouponSystemException("getOneCustomer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

}
