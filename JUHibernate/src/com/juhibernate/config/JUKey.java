package com.juhibernate.config;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import com.juhibernate.crud.JUOSearch;
import com.juhibernate.crud.JUSelect;

public class JUKey {

	private static String uniqueIndex;
	private static int rowIndex;

	public static String getUniqueIndex(JTextField infoTextField, String uniqueIndex, String tableName) {
		JUKey.uniqueIndex = uniqueIndex;

		rowIndex = 0;

		try {

			if (JUOSearch.searchTable(JUDBCConnect.createConnection(infoTextField), tableName, infoTextField)
					.next()) {

				final ResultSet resultSetObj = JUSelect.getRecords(JUDBCConnect.createConnection(infoTextField),
						tableName, infoTextField);

				while (resultSetObj.next())
					++rowIndex;
			}

		} catch (final SQLException e) {
			infoTextField.setText(e.getMessage() + " " + new JUKey().getClass().getSimpleName());
			infoTextField.setForeground(Color.RED);
		}

		return JUKey.uniqueIndex += rowIndex;
	}
}