/**
 * 
 */
package com.juhibernate.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.juhibernate.config.JUDBCConnect;
import com.juhibernate.config.JUdbSS;
import com.juhibernate.config.JUtil;
import com.juhibernate.crud.JDBCUSelect;
import com.juhibernate.crud.JUCrud;
import com.juhibernate.crud.JUOSearch;
import com.juhibernate.crud.JUSelect;
import com.juhibernate.crypto.JUEncoder;
import com.juhibernate.oper.JUOperate;
import com.juhibernate.sdb.JUHData;
import com.juhibernate.user.JUSUser;
import com.juhibernate.user.JUSUserDetails;

/**
 * @author @JMchfundi
 *
 */
public class JUTest {

	private static Scanner scannerObj;

	private static JUtil<JUHData> utilObj;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lunch();
	}

	public static void lunch() {
		JUdbSS.dbStart();
		try {
			utilObj = new JUtil<JUHData>(JUHData.class);

			utilObj.getSessionFactory();

			if (JUOSearch.searchTable(JUDBCConnect.createConnection(null), JUHData.TableName.TABLENAME, null).next()) {

				try {
					if (JUSelect.getRecords(JUDBCConnect.createConnection(null), JUHData.TableName.TABLENAME, null)
							.next() == false) {
						saveSalesObj();
					}
				} catch (SQLException e) { // TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				checkingAuthentication(JUDBCConnect.createConnection(null));

			} else {
				saveSalesObj();
				checkingAuthentication(JUDBCConnect.createConnection(null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void checkingAuthentication(Connection conObj) {

		scannerObj = new Scanner(System.in);

		System.out.println("Authentication Required... Please give login credentials:...");
		System.out.println("User Name:\n");
		String usrName = scannerObj.nextLine();
		if (!(usrName.toString().length() >= 1)) {
			System.out.println("Cant Operate With Null User");
			checkingAuthentication(conObj);
		}

		System.out.println("Password:\n");
		String pswd = scannerObj.nextLine();
		if (!(pswd.toString().length() >= 1)) {
			System.out.println("Cant Operate With Null Password");
			checkingAuthentication(conObj);
		}

		List<JUHData> userDataObj = JUHData.GEP_User_DataList
				.createList(JDBCUSelect.selectRecordFromTable(JUDBCConnect.createConnection(null),
						JUHData.TableName.TABLENAME, "id", JUEncoder.encodeData(usrName)), null);

		if (!userDataObj.isEmpty()) {
			if (pswd.equals(userDataObj.get(0).getWord())) {
				JUSUser.setSystemUser(userDataObj.get(0).getId(), userDataObj.get(0).getUser_authencity(),
						userDataObj.get(0).getLocation());
				System.out.println("Hurrah!!! Login successful...");
				new JUOperate().selectOperation();
			} else {
				System.out.println("Ooops!!! Incorrect Password!!! Login failed... Try Again");
				checkingAuthentication(JUDBCConnect.createConnection(null));
			}
		} else {
			System.out.println("Ooops!!! User Not Recognized...");
			checkingAuthentication(JUDBCConnect.createConnection(null));
		}
	}

	private static void saveSalesObj() {
		try {
			new JUCrud(JUSUserDetails.getUserDataEntries(), utilObj.getSessionFactory()).saveObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
