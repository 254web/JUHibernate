package com.juhibernate.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUSelect {

	public static ResultSet selectRecordFromTable(Connection conObj, String dbTableName, String dbTableID,
			String idValue) {

		dbTableID += "=?";
		final String selectTableDetails = "SELECT * FROM " + dbTableName + " WHERE " + dbTableID;

		ResultSet rs = null;
		try {
			final PreparedStatement ps = conObj.prepareStatement(selectTableDetails);

			ps.setString(1, idValue);

			rs = ps.executeQuery();
		} catch (final SQLException e) {
			System.out.println(e.getMessage());
		}

		return rs;
	}
}