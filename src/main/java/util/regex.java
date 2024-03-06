package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class regex {
	public static boolean checkEmailRegex(String email)
	{
		boolean check = false ;
		Pattern pattern  =  Pattern.compile("^[A-Za-z]+[A-Za-z0-9]+@gmail.com$");
		if(pattern.matcher(email).find())
		{
			check = true ;
		}
		return check;
	}
	
   public static void main(String[] args) {
	 regex test =  new regex();
	 System.out.println(test.checkEmailRegex("ductrantad23@gmail.com"));
}
}
