package com.juhibernate.config;

import java.io.IOException;

public class JUdbSS {

	public static void dbStart() {
		// TODO Auto-generated method stub
		try {
			if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
				Runtime.getRuntime().exec("chmod +x startdb");
				Runtime.getRuntime().exec("./startdb");

			} else
				Runtime.getRuntime().exec("cmd /k start startdb.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void dbStop() {
		// TODO Auto-generated method stub
		try {
			if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
				Runtime.getRuntime().exec("chmod +x stopdb");
				Runtime.getRuntime().exec("./stopdb");
			} else
				Runtime.getRuntime().exec("cmd /k start stopdb.bat");
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
