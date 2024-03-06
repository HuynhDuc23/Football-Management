package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class encode {
    public static String encodeData(String data) {
        try {
            // Create a MessageDigest instance with the chosen algorithm (SHA-256)
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Convert the input data to bytes and hash it
            byte[] hashedBytes = messageDigest.digest(data.getBytes());

            // Convert the hashed bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception appropriately (print or log an error message)
            e.printStackTrace();
            return null;
        }
    }
    public static String toSHA1(String str)
    {
    	String salt = "asdjgasdjhabdbasgdad12398";
    	String result = null ;
    	str+=salt ;
    	try {
		 byte [] dataBytes =  str.getBytes("UTF-8");
		 MessageDigest md = MessageDigest.getInstance("SHA-1");
		 // sucess encode
		//	 result = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result ;
    }
}
