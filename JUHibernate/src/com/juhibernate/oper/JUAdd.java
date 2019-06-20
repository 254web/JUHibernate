/**
 * 
 */
package com.juhibernate.oper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.juhibernate.config.JUKey;
import com.juhibernate.config.JUtil;
import com.juhibernate.crud.JUCrud;
import com.juhibernate.crypto.JUDecoder;
import com.juhibernate.crypto.JUEncoder;
import com.juhibernate.sdb.JUHData;
import com.juhibernate.user.JUSUser;
import com.juhibernate.util.JUError;
import com.juhibernate.util.JUUtilDateToSqlDate;

/**
 * @author JMchfundi
 *
 */
public class JUAdd {

	private Scanner scannerObj;

	private HashMap<Integer, String> mapObj;
	private JUHData dataObj;

	public void getUserData() {

		scannerObj = new Scanner(System.in);
		dataObj = new JUHData();
		mapObj = new HashMap<>();

		System.out.println("Input User Data");
		dataObj.setId(JUEncoder.encodeData(
				JUKey.getUniqueIndex(null, JUHData.Unique_Box.UNIQUE_BOX, JUHData.TableName.TABLENAME.toString())));
		System.out.println("Full Name");
		dataObj.setName(JUEncoder.encodeData(scannerObj.nextLine().toString()));
		if (!(dataObj.getName().toString().length() >= 1)) {
			System.out.println("Null User Not Accepted");
			getUserData();
		}

		dataObj.setWord(JUEncoder.encodeData(JUHData.Unique_Box.DEFAUL_WORD.toString()));

		System.out.println("Location");
		dataObj.setLocation(JUEncoder.encodeData(scannerObj.nextLine().toString()));
		if (!(dataObj.getLocation().toString().length() >= 1)) {
			System.out.println("Null Location Not Accepted");
			getUserData();
		}

		dataObj.setCreator(JUEncoder.encodeData(JUSUser.getUserName().toString()));
		dataObj.setActive_mult(0);
		dataObj.setLast_log(JUUtilDateToSqlDate.convertUtilToSqlDate(new Date().toString()));
		operation(mapObj, dataObj);

		try {
			new JUCrud(dataObj, new JUtil<>(JUHData.class).getSessionFactory()).saveObject();

			System.out.println("Kindly Note Down Your User Id & Password\n\n");
			System.out.println("ID " + JUDecoder.decodeData(dataObj.getId().toString()));
			System.out.println("Default Password " + JUDecoder.decodeData(dataObj.getWord().toString()));
			System.out.println("Be Ware To Change Your Password In Next Login In");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * private void userData() {
	 * 
	 * Field[] fields = JUHData.class.getDeclaredFields();
	 * 
	 * for (Field field : fields) {
	 * System.out.println(field.toString().substring(field.toString().indexOf(
	 * "JUHData") + 8)); }
	 * 
	 * }
	 */

	private void operation(HashMap<Integer, String> mapObj, JUHData dataObj) {
		int selectionIndex = 0;

		System.out.println("Select Authority");

		mapObj.put(1, JUSUser.GetUserAutho.ADMIN);
		mapObj.put(2, JUSUser.GetUserAutho.STANDARD);
		mapObj.put(3, JUSUser.GetUserAutho.NORMAL);

		for (Map.Entry<Integer, String> operation : mapObj.entrySet()) {
			System.out.println(operation.getKey() + " " + operation.getValue());
		}

		selectionIndex = scannerObj.nextInt();

		switch (selectionIndex) {
		case 1:
			dataObj.setUser_authencity(JUEncoder.encodeData(JUSUser.GetUserAutho.ADMIN.toString()));
			break;
		case 2:
			dataObj.setUser_authencity(JUEncoder.encodeData(JUSUser.GetUserAutho.STANDARD.toString()));
			break;
		case 3:
			dataObj.setUser_authencity(JUEncoder.encodeData(JUSUser.GetUserAutho.NORMAL));
			break;

		default:
			System.out.println(JUError.SELECT_ERROR);
			operation(mapObj, dataObj);
			break;
		}
	}

}
