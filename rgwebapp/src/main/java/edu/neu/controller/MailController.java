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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import edu.neu.model.EMail;
import edu.neu.service.MailService;
import edu.neu.service.PersonService;

import javax.annotation.Resource;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;
    
    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/rest/sendmail", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> sendMovementEmail (@RequestParam("file") MultipartFile[] intruderImage, @RequestParam("emailAddress") String emailAddress) {
        //System.out.println("Person is"+ person);
        //System.out.println("Person is"+ person.getFirstName());
    	EMail emailData = new EMail();
    	emailData.setPerson(personService.getPersonByEmail(emailAddress));
    	
        mailService.sendEmail(emailData);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
}
