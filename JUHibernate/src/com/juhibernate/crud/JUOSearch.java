package com.juhibernate.crud;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class JUOSearch {
	private static ResultSet resultSetObj;
	private static DatabaseMetaData metaDataObj;

	public static ResultSet searchTable(Connection conObj, String objectName, JTextField infoTextField) {
		try {
			metaDataObj = conObj.getMetaData();
			resultSetObj = metaDataObj.getTables(null, null, objectName, null);
		} catch (final SQLException e) {
			System.out.println(e.getMessage());
		}

		return resultSetObj;
	}
}
