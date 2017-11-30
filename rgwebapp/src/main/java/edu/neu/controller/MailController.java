package edu.neu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import edu.neu.model.EMail;
import edu.neu.service.MailService;

import javax.annotation.Resource;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/sendmail", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> sendMovementEmail (@RequestBody EMail mail) {
        //System.out.println("Person is"+ person);
        //System.out.println("Person is"+ person.getFirstName());
        mailService.sendEmail(new EMail());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
}
