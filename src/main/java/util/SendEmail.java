package util;

import java.util.*;  



import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

 
  
public class SendEmail  
{  
	public SendEmail() {
		// TODO Auto-generated constructor stub
	}
	public static String send(String email) {

         String username = "ductrantad23@gmail.com";
         String password = "ctcngghrwasklxgt";
         // Đăng ký trong gmail
         int min = 100000;
         int max = 999999;
       
         int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
         
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ductrantad23@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Your OTP reset Password");
            message.setText("Dear "+email
                    + " :" +random_int);

            Transport.send(message);

           

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        return Integer.toString(random_int);
    }
	public static void main(String[] args) {
		System.out.println(send("ductrantad23@gmail.com"));
	}
}  