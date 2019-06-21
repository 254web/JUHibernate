/**
 * 
 */
package com.juhibernate.oper;

import java.util.List;

import com.juhibernate.config.JUDBCConnect;
import com.juhibernate.crud.JUSelect;
import com.juhibernate.sdb.JUHData;

/**
 * @author Jakida
 *
 */
public class JUView {

	private List<JUHData> listObj;

	public void viewUserData() {

		listObj = JUHData.GEP_User_DataList.createList(
				JUSelect.getRecords(JUDBCConnect.createConnection(null), JUHData.TableName.TABLENAME, null), null);

		for (JUHData dataObj : listObj) {
			System.out.println(dataObj.getId() + dataObj.getName() + dataObj.getWord() + dataObj.getUser_authencity()
					+ dataObj.getCreator() + dataObj.getLocation() + dataObj.getActive_mult() + dataObj.getLast_log());
		}
	}

}
