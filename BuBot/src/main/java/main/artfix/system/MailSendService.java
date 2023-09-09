package main.artfix.system;

import main.artfix.Application;
import main.artfix.MainConfig;
import main.artfix.other.SystemAutoReset;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailSendService {
    public static void send(String body) {
        if(!FileIng.read("admin-mail").equals("no")) {
            try {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MainConfig.gmailUsername, MainConfig.gmailPassword);
                    }
                });
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(MainConfig.gmailUsername + "@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(FileIng.read("admin-mail")));
                message.setSubject("WARNING | BuBot | SECURITY SYS");
                message.setText(body);
                Transport.send(message);
            } catch (Exception e) {
                System.out.println("System ERROR! -> Mail");
                SystemAutoReset.start();
                Application.applicationWorking = false;
            }
        }
    }
}
