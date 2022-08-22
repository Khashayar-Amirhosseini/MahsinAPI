/*
package com.MahSinApi.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
public class EmailValidation {

    @RequestMapping("/emailValidation.do")
    public Object sendValidationEmail(){
        String to = "kh.amirhosseini@gmail.com";
        String from = "kh.amirhosseini@gmail.com";
        final String username = "kh.amirhosseini@gmail.com";
        final String password = "13701369";
        String host = "tsmtp.gmail.com";

        Properties props = (Properties) new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port", "25");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            try {
                message.setFrom(new InternetAddress(from));
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }

            // Set To: header field of the header.
            try {
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }

            // Set Subject: header field
            try {
                message.setSubject("Testing Subject");
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }

            // Now set the actual message
            try {
                message.setText("Hello, this is sample for to check send " +
                        "email using JavaMailAPI ");
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }

            // Send message
            try {
                Transport.send(message);
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }

            System.out.println("Sent message successfully....");

        return "ok";

    }

}
*/
