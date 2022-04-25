package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

	static boolean flag = false;

	public static boolean nameValidation(String name) {

		Pattern p = Pattern.compile("[aA-zZ]*");
		Matcher m = p.matcher(name);

//		name.trim().equals("") 

		if (m.matches() == true && name != null && !name.equals(""))
			return true;

		else
			return false;
	}

	public static boolean ageValidation(int age) {

		if (age >= 18)
			return true;

		else
			return false;

	}

	public static boolean emailValidation(String email) {

		String regex1 = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//		String regex1 = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

		Pattern p1 = Pattern.compile(regex1);
		Matcher m = p1.matcher(email);// input

		if (email != null && m.matches() == true)
			return true;
		else {
			System.out.println("Email = false");
			return false;
		}

	}

	public static boolean passwordValidation(String password) {

//		String regex2 = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,10})";
		String regex2 = "^.*(?=.{8,16})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		Pattern p2 = Pattern.compile(regex2);// expression
		Matcher mp = p2.matcher(password);// input

		if (mp.matches() == true && password != null && !password.equals("")) {
			System.out.println("sachu j che la");
			return true;

		} else {
			return false;
		}

	}

	public static boolean phoneValidation(String phone) {

		String regex2 = "^\\d{10}$";
		Pattern p2 = Pattern.compile(regex2);// expression
		Matcher mp = p2.matcher(phone);// input

		if (mp.matches() == true && phone != null && !phone.equals("")) {
			System.out.println("sachu j che la");
			return true;

		} else {
			return false;
		}

	}

}
