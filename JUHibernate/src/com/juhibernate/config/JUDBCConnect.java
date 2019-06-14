/**
 * @author Akida M Jafar
 * projectIndia connection class
 */
package com.juhibernate.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;

/*
 *public class JdbcConnect{...};
 */
public class JUDBCConnect {

	private static String db_driver;

	/*
	 * Can also use oracle.jdbc.driver.OracleDriver Type driver for Oracle_DB
	 */

	private static String db_url;
	private static String db_user;
	private static String db_password;

	/*
	 * createConnection() method for establishment of DB connection its a public
	 * method returns Connection object as a value takes no arguments
	 */
	@SuppressWarnings("rawtypes")
	public static Connection createConnection(JTextField infoTextField) {
		final Vector connectionProperties = JUProRead.getPropetiesFile();

		/*
		 * Initialization of CONSTANT variables i. db_driver ii. db_url iii. db_user iv.
		 * db_password
		 */
		db_driver = (String) connectionProperties.elementAt(0);
		db_url = (String) connectionProperties.elementAt(1);
		db_user = (String) connectionProperties.elementAt(2);
		db_password = (String) connectionProperties.elementAt(3);

		/*
		 * Connection conObj local variable nullified
		 */
		Connection conObj = null;

		/*
		 * registration of the sun.jdbc.odbc.JdbcOdbcDriver & the creation of the
		 * connection to the DB
		 */
		try {
			Class.forName(db_driver);
		} catch (final ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			conObj = DriverManager.getConnection(db_url, db_user, db_password);
		} catch (final SQLException e) {
			System.out.println(e.getMessage());
		}
		// returning final value of conObj
		return conObj;
	}

	private JUDBCConnect() {

	}
}
