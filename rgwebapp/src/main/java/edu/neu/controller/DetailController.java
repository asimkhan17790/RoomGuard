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

import edu.neu.exception.AccountDoesNotExistException;
import edu.neu.exception.AccountExistsException;
import edu.neu.exception.ConflictException;
import edu.neu.exception.PersonErrorInformation;
import edu.neu.model.Person;
import edu.neu.service.PersonService;

import java.util.List;

@RestController
public class DetailController {

    @Autowired
    private DetailService detailService;

 

    /**
     * Create a user with the given credentials
     * @param person :- The information regarding to the user with primary key as emailAddress
     * @return if no conflict in email address than returns the auto increment id of the user
     *  or if there is an user with the same email address return a 409 conflict code
     */
//    @RequestMapping(value = "/rest/user", method = RequestMethod.POST)
//    public ResponseEntity<?> createUser (@RequestBody Person person ,UriComponentsBuilder ucBuilder) {	
//    	try {
//            Person p = personService.addPerson(person);
//            HttpHeaders headers = new HttpHeaders();
//       	 	return new ResponseEntity<Person>(p, headers, HttpStatus.CREATED);
//        } catch(AccountExistsException exception) {
//            throw new ConflictException();
//        }
//    }
   

}
