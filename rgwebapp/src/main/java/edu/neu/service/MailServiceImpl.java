package edu.neu.service;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;

import edu.neu.model.EMail;
import edu.neu.utils.GmailModule;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Override
    public String sendEmail(EMail mail) {
        System.out.println("Sending Email start...");
        
        try {
        	 Gmail service = GmailModule.getGmailService();

             // Print the labels in the user's account.
             String user = "me";
             ListLabelsResponse listResponse =
                     service.users().labels().list(user).execute();
             List<Label> labels = listResponse.getLabels();
             if (labels.size() == 0) {
                 System.out.println("No labels found.");
             } else {
                 System.out.println("Labels:");
                 for (Label label : labels) {
                     System.out.printf("- %s\n", label.getName());
                 }
             }
             MimeMessage m = null;
             try {
                 m = GmailModule.createEmail("asim.khan17@hotmail.com", mail.getPerson().getEmailAddress(), "Hello From Java", "Hi,, Checking the Gmail API in Java",null);
             } catch (MessagingException e) {
                 e.printStackTrace();
             }
             try {
             	GmailModule.sendMessage(service, "me", m);
             } catch (MessagingException e) {
                 e.printStackTrace();
             }
        }
       
        catch (IOException e) {
            e.printStackTrace();
        }


        return "mailSent";
    }
}
