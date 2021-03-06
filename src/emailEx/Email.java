package emailEx;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

private static String USER_NAME = "keyurmulani786@gmail.com";  // GMail user name (just the part before "@gmail.com")
private static String PASSWORD = "punya786"; // GMail password
private static String RECIPIENT = "iipratik2410@gmail.com";

public static void main(String[] args) {
    String from = USER_NAME;
    String pass = PASSWORD;
    String[] to = { RECIPIENT }; // list of recipient email addresses
    String subject = "Java send mail example";
    String body = "hi ....,!";
    sendFromGMail(from, pass, to, subject, body);
}

private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
    Properties props = System.getProperties();
  String host = "smtp.gmail.com";

   /* props.put("mail.smtp.ssl.trust", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "25");
   // props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
 
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.EnableSSL.enable","true");
//    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.starttls.required", "true");*/
  
  props.put("mail.smtp.user",USER_NAME); 
  props.put("mail.smtp.host", "smtp.gmail.com"); 
  props.put("mail.smtp.port", "25"); 
  props.put("mail.debug", "true"); 
  props.put("mail.smtp.auth", "true"); 
  props.put("mail.smtp.starttls.enable","true"); 
  props.put("mail.smtp.EnableSSL.enable","true");
  props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
  props.setProperty("mail.smtp.socketFactory.fallbac k", "false"); 
  props.setProperty("mail.smtp.port", "465"); 
  props.setProperty("mail.smtp.socketFactory.port", "465"); 

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {


        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }



        message.setSubject(subject);
        message.setText(body);


        Transport transport = session.getTransport("smtp");


        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
    catch (AddressException ae) {
        ae.printStackTrace();
    }
    catch (MessagingException me) {
        me.printStackTrace();
    }
    }
   }