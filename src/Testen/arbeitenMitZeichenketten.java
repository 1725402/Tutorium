package Testen;

import java.util.regex.*;


public class arbeitenMitZeichenketten {

	public static void main(String[] args) {
		String mail = "marius.berlinghof@gmail.com";
		System.out.println(musterEMail(mail));
	}

	public static boolean musterEMail (String s) {
		if (s == null)
			return false;
		return s.matches("[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
	}
}
