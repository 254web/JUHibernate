package com.juhibernate.user;

public class JUSUser {
	public interface GetUserAutho {
		String ADMIN = "Admin";
		String STANDARD = "Standard";
		String NORMAL = "Normal";
		String USERNAME = "User";
	}

	private static String userName;
	private static String userAutho;

	private static String userLocation;

	public static String getUserAutho() {
		return userAutho;
	}

	public static String getUserLocation() {
		return userLocation;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setSystemUser(String userName, String userAutho, String userLocation) {
		JUSUser.userName = userName;
		JUSUser.userAutho = userAutho;
		JUSUser.userLocation = userLocation;
	}
}