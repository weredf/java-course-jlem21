package coupons.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import coupons.core.exceptions.CouponSystemException;

public class ConnectionPool {

	public static final int SIZE = 5;
	private boolean open = false;
	private String dbUrl = "jdbc:mysql://localhost:3306/coupon_system";
	private String user = "root";
//	private String password = "1234";
	private String password = "aaaa1234";
	private Set<Connection> connections = new HashSet<>();

	// singleton
	private static ConnectionPool instance;

	// CTOR
	private ConnectionPool() throws SQLException {
		// create connections and add to the set
		for (int i = 0; i < SIZE; i++) {
			Connection con = DriverManager.getConnection(dbUrl, user, password);
			connections.add(con);
		}
		this.open = true; // using 'this' only to find what's available
	}

	// getter for private singleton object
	// method catches exception from private method ConnectionPool() and throws
	// local exception
	/**
	 * Getter for private singleton object ConnectionPool
	 * @return instance ConnectionPool
	 * @throws CouponSystemException
	 */
	public static ConnectionPool getInstance() throws CouponSystemException {
		if (instance == null) {
			try {
				instance = new ConnectionPool();
			} catch (SQLException e) {
				throw new CouponSystemException("connection pool failed to start", e);
			}
		}
		return instance;
	}

	// check if open, check if connection available or wait, get one connection from
	// the set of connections, remove from set
	/**
	 * Checks if connection pool is open, and a connection is available (or wait),
	 * gets one connection from the set of connections (removes from the set)
	 * 
	 * @return Connection
	 * @throws CouponSystemException
	 */
	public synchronized Connection getConnection() throws CouponSystemException {
		if (!open) {
			throw new CouponSystemException("getConnection failed - pool is closed");
		}
		while (connections.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Connection> iterator = connections.iterator();
		Connection con = iterator.next();
		iterator.remove();
		return con;
	}

	// add connection to the set and notify
	/**
	 * Returns connection to the set and notifies
	 * 
	 * @param connection
	 */
	public synchronized void restoreConnection(Connection connection) {
		connections.add(connection);
		notify();
	}

	// first close the pool so nothing can be taken out anymore
	// then wait until all connections are returned
	// close all connections and remove from set
	/**
	 * Closes the connection pool, waits until all connections are returned, closes
	 * all connections and removes them from the set
	 * 
	 * @throws CouponSystemException
	 */
	public synchronized void closeAllConnections() throws CouponSystemException {
		open = false;
		while (connections.size() < SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < SIZE; i++) { // alternatively, for each loop to close, clear to empty the set
			Iterator<Connection> iterator = connections.iterator();
			Connection con = iterator.next();
			try {
				con.close();
			} catch (SQLException e) {
				throw new CouponSystemException("closeAllConnections failed", e);
			}
			iterator.remove();
		}
	}

}
