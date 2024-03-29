package edu.kau.fcit.cpit252.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void send(String subject, String body, String recipient) throws MissingRequiredPropetiesException{
         final String username = "temp48846@gmail.com";
         final String password = "ASA.9098";

        if (username == "" || password == "") {
            throw new MissingRequiredPropetiesException("Missing email username and/or password. You need to store two" +
                    " environment variables named: \"email\" and \"password\" for your email account."  +
                    " Please refer to the following link for more information on how to set environment variables:" +
                    " https://cpit252.gitlab.io/miscellaneous/#environment-variables");
        }

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(subject);
            // line 42 error
            message.setContent(body, "text/html;charset=utf-8");
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
