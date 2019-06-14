package com.juhibernate.crypto;

import java.io.IOException;

import javax.swing.JOptionPane;

import sun.misc.BASE64Decoder;

public class JUDecoder {
	private static String stringObj;

	public static String decodeData(String stringObj) {
		final BASE64Decoder decoderObj = new BASE64Decoder();

		try {
			JUDecoder.stringObj = new String(decoderObj.decodeBuffer(stringObj));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), new JUDecoder().getClass().getSimpleName(),
					JOptionPane.ERROR_MESSAGE);
		}

		return JUDecoder.stringObj;
	}

	private JUDecoder() {
		// TODO Auto-generated constructor stub
	}
}
