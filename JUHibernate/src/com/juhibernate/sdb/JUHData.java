/**
 * (c) Akida M Jafar, PJP
 */
package com.juhibernate.sdb;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JTextField;

import com.juhibernate.crypto.JUDecoder;

/**
 * @author Jei Mchfundi
 *
 */
@Entity
public class JUHData {
	public static class GEP_User_DataList {
		private static List<JUHData> listObj;

		public static List<JUHData> createList(ResultSet resultSetObj, JTextField infoTextField) {

			listObj = new LinkedList<JUHData>();

			try {
				while (resultSetObj.next()) {
					final JUHData dataObj = new JUHData();

					dataObj.setId(JUDecoder.decodeData(resultSetObj.getObject("id").toString()));
					dataObj.setName(JUDecoder.decodeData(resultSetObj.getObject("name").toString()));
					dataObj.setWord(JUDecoder.decodeData(resultSetObj.getObject("word").toString()));
					dataObj.setLocation(JUDecoder.decodeData(resultSetObj.getObject("location").toString()));
					dataObj.setCreator(JUDecoder.decodeData(resultSetObj.getObject("creator").toString()));
					dataObj.setActive_mult(resultSetObj.getInt("active_mult"));
					dataObj.setLast_log(resultSetObj.getDate("last_log"));
					dataObj.setUser_authencity(
							JUDecoder.decodeData(resultSetObj.getObject("user_authencity").toString()));

					listObj.add(dataObj);
				}
			} catch (final SQLException e) {
				infoTextField.setText(e.getMessage() + " " + new JUHData().getClass().getSimpleName());
			}

			return listObj;
		}
	}

	public static class GEP_User_DataListForUpdate {
		private static List<JUHData> listObj;

		public static List<JUHData> createList(ResultSet resultSetObj, JTextField infoTextField) {

			listObj = new LinkedList<JUHData>();

			try {
				while (resultSetObj.next()) {
					final JUHData dataObj = new JUHData();

					dataObj.setId(resultSetObj.getObject("id").toString());
					dataObj.setName(resultSetObj.getObject("name").toString());
					dataObj.setWord(resultSetObj.getObject("word").toString());
					dataObj.setLocation(resultSetObj.getObject("location").toString());
					dataObj.setCreator(resultSetObj.getObject("creator").toString());
					dataObj.setActive_mult(Integer.parseInt(resultSetObj.getObject("active_mult").toString()));
					dataObj.setLast_log(resultSetObj.getDate("last_log"));
					dataObj.setUser_authencity(resultSetObj.getObject("user_authencity").toString());

					listObj.add(dataObj);
				}
			} catch (final SQLException e) {
				infoTextField.setText(e.getMessage() + " " + new JUHData().getClass().getSimpleName());
			}

			return listObj;
		}
	}

	public interface TableName {
		String TABLENAME = new JUHData().getClass().getSimpleName().toUpperCase();
	}

	public interface Unique_Box {
		String UNIQUE_BOX = "ju2019.";
		String DEFAUL_WORD = "Password123";
	}

	private String id;
	private String name;
	private String word;
	private String location;

	private String creator;

	private int active_mult;

	private Date last_log;

	private String user_authencity;

	public int getActive_mult() {
		return active_mult;
	}

	public String getCreator() {
		return creator;
	}

	@Id
	public String getId() {
		return id;
	}

	public Date getLast_log() {
		return last_log;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getUser_authencity() {
		return user_authencity;
	}

	public String getWord() {
		return word;
	}

	public void setActive_mult(int active_mult) {
		this.active_mult = active_mult;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLast_log(Date last_log) {
		this.last_log = last_log;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser_authencity(String user_authencity) {
		this.user_authencity = user_authencity;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
