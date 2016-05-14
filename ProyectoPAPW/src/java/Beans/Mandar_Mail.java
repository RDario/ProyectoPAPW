/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mandar_Mail {
    
    public Mandar_Mail(String Para, String Titulo, String Asunto, String Mensaje){
        send(Para, Titulo, Asunto, Mensaje);
    }
    
    public void send(String Para, String Titulo, String Asunto, String Mensaje){
        try{
            Properties props = new Properties();       
            props.setProperty("mail.smtp.host", "smtp.live.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.user", "dibujan_2-s_@hotmail.com");
            props.setProperty("mail.smtp.auth", "true");
            System.out.print("Mail Enviado");
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            Address desde = new InternetAddress("dibujan_2-s_@hotmail.com",  Titulo);
            Address para = new InternetAddress(Para);
            message.setFrom(desde);
            message.addRecipient(Message.RecipientType.TO, para);
            message.setSubject(Asunto);
            message.setText(Mensaje);
            Transport t = session.getTransport("smtp");
            t.connect("dibujan_2-s_@hotmail.com", "MA627ZY/A2012");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }
        catch(UnsupportedEncodingException | MessagingException e){
        }
    }
}
