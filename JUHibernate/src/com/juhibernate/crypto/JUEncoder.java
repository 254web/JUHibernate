package com.juhibernate.crypto;

import sun.misc.BASE64Encoder;

public class JUEncoder {

	public static String encodeData(String stringObj) {
		final BASE64Encoder encoderObj = new BASE64Encoder();

		return new String(encoderObj.encodeBuffer(stringObj.getBytes()));
	}

	private JUEncoder() {
		// TODO Auto-generated constructor stub
	}
}
