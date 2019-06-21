/**
 * 
 */
package com.juhibernate.oper;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.juhibernate.util.JUError;

/**
 * @author root
 *
 */
public class JUOperate {

	private Scanner scannerObj;
	private HashMap<Integer, String> mapObj;

	public void selectOperation() {
		scannerObj = new Scanner(System.in);

		System.out.println("Select Operation");
		operation();

		try {
			switch (scannerObj.nextInt()) {
			case 1:
				new JUAdd().getUserData();
				break;

			case 4:
				new JUView().viewUserData();
				break;
			default:
				System.out.println(JUError.SELECT_ERROR);
				selectOperation();
				break;
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			selectOperation();
		}

	}

	private void operation() {

		mapObj = new HashMap<>();

		mapObj.put(1, "Add User");
		mapObj.put(2, "Update User");
		mapObj.put(3, "Delet User");
		mapObj.put(4, "View Users");

		for (Map.Entry<Integer, String> operation : mapObj.entrySet()) {
			System.out.println(operation.getKey() + " " + operation.getValue());
		}
	}
}
