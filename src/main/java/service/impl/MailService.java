package service.impl;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailService {

    public static void sendEmail(Session session,//String host, String port,
                                // final String senderEmail, //String senderName
                                 //  final String password,
                                 String recipientEmail, String subject, String message) throws AddressException,
            MessagingException, UnsupportedEncodingException {

    // sets SMTP server properties
//    Properties properties = new Properties();
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");

    // creates a new session with an authenticator
//    Authenticator auth = new Authenticator() {
//        public PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(senderEmail, password);
//        }
//    };
//
//    Session session = Session.getInstance(properties, auth);

    // creates a new e-mail message
//    Message msg = new MimeMessage(session);
//
//
//        msg.setFrom(new InternetAddress(senderEmail, senderName));
//    InternetAddress[] toAddresses = { new InternetAddress(recipientEmail) };
//        msg.setRecipients(Message.RecipientType.TO, toAddresses);
//        msg.setSubject(subject);
//        msg.setSentDate(new Date());
//        msg.setText(message);
//
//    // sends the e-mail
//        Transport.send(msg);
        try{Message msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress("maryankakravets@gmail.com"));//, "NoReply-JD"));

//        msg.setReplyTo(InternetAddress.parse(recipientEmail, false));
//
//        msg.setSubject(subject, "UTF-8");
//
//        msg.setText(message, "UTF-8");
//
//        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));
            MimeBodyPart text=new MimeBodyPart();
            Multipart multipart=new MimeMultipart();
            String finalText= "subject"+ subject+message+"message";
            text.setText(finalText);
            msg.setSubject(subject);
            multipart.addBodyPart(text);
            msg.setContent(multipart);
            msg.setSubject("Contact Details");
//        System.out.println("Message is ready");
        Transport.send(msg);

        System.out.println("EMail Sent Successfully!!");
    }
	    catch (Exception e) {
        e.printStackTrace();
    }
}

}

