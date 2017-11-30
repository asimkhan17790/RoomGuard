package edu.neu.service;


import org.springframework.stereotype.Service;

import edu.neu.model.EMail;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Override
    public String sendEmail(EMail mail) {
        System.out.println("Sending Email start...");

        return "mailSent";
    }
}
