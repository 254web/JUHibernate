package com.juhibernate.user;

import java.util.Date;

import com.juhibernate.crypto.JUEncoder;
import com.juhibernate.sdb.JUHData;
import com.juhibernate.util.JUUtilDateToSqlDate;

public class JUSUserDetails {

	public static JUHData getUserDataEntries() {
		final JUHData userData = new JUHData();

		userData.setId(JUEncoder.encodeData(JUSUser.GetUserAutho.USERNAME));
		userData.setName(JUEncoder.encodeData("Parent User"));
		userData.setWord(JUEncoder.encodeData("Password123"));
		userData.setLocation(JUEncoder.encodeData("Parent User"));
		userData.setCreator(JUEncoder.encodeData("Parent User"));
		userData.setActive_mult(0);
		userData.setLast_log(JUUtilDateToSqlDate.convertUtilToSqlDate(new Date().toString()));
		userData.setUser_authencity(JUEncoder.encodeData(JUSUser.GetUserAutho.ADMIN));

		return userData;
	}

	private JUSUserDetails() {

	}
}
