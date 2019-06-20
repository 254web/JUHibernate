package com.juhibernate.crud;

import java.io.Serializable;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class JUCrud {

	private Object objectData;
	private Session sessionObj;
	private Transaction transactionObj;
	private Serializable serializableObj;

	public JUCrud(Object objectData, SessionFactory sessionFactoryObj) {
		// Initializing ObjectData & sessionObj
		this.objectData = objectData;

		sessionObj = sessionFactoryObj.openSession();
	}

	private JUCrud() {
		// TODO Auto-generated constructor stub
	}

	public Serializable saveObject() {

		transactionObj = sessionObj.beginTransaction();
		serializableObj = (Serializable) sessionObj.save(objectData);

		try {
			transactionObj.commit();
		} catch (Exception e) {
			transactionObj.rollback();

			System.out.println(e.getMessage());
		}

		sessionObj.close();

		return serializableObj;
	}

	public void saveorupdateObject() {

		transactionObj = sessionObj.beginTransaction();
		sessionObj.saveOrUpdate(objectData);
		try {
			transactionObj.commit();

			JOptionPane.showMessageDialog(null, "Updation Succeded Successfully",
					new JUCrud().getClass().getSimpleName(), JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			transactionObj.rollback();
			JOptionPane.showMessageDialog(null, e.getMessage(), new JUCrud().getClass().getSimpleName(),
					JOptionPane.ERROR_MESSAGE);
		}

		sessionObj.close();
	}
}