package com.juhibernate.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class JUSelect {
	public static ResultSet getRecords(Connection connectionObj, String tableName, JTextField infoTextField) {
		final String selectTableDetails = "SELECT * FROM " + tableName;
		ResultSet resultSetObj = null;
		try {
			final PreparedStatement ps = connectionObj.prepareStatement(selectTableDetails);

			resultSetObj = ps.executeQuery();
		} catch (final SQLException e) {
			System.out.println(e.getMessage());
		}

		return resultSetObj;
	}
}