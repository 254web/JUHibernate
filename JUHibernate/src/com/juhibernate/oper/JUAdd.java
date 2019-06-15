/**
 * 
 */
package com.juhibernate.oper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.juhibernate.sdb.JUHData;
import com.juhibernate.user.JUSUser;

/**
 * @author root
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
		System.out.println("Full Name");
		System.out.println("Password");
		System.out.println("Location");
		operation(mapObj, dataObj);

	}

	private void userData() {

		Field[] fields = JUHData.class.getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field.toString().substring(field.toString().indexOf("JUHData") + 8));
		}

	}

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

			break;
		case 2:

			break;
		case 3:

			break;

		default:

			break;
		}
	}

}
