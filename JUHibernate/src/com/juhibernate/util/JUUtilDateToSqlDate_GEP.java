package com.juhibernate.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class JUUtilDateToSqlDate_GEP {

	public static java.sql.Date convertUtilToSqlDate(String userDateObj) {
		final DateFormat dateFormatObj = new SimpleDateFormat("dd-MM-yyyy");
		Date utilDateObj = null;

		try {
			utilDateObj = dateFormatObj.parse(userDateObj);
		} catch (final ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					new JUUtilDateToSqlDate_GEP().getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
		}

		final java.sql.Date sqlDateObj = new java.sql.Date(utilDateObj.getTime());

		return sqlDateObj;
	}
}
