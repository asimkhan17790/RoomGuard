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
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Person> listPersons() {
       // model.addAttribute("person", new Person());
       // model.addAttribute("listPersons", this.personService.listPersons());
       // return "person";
        return this.personService.listPersons();
    }

    /**
     * Create a user with the given credentials
     * @param person :- The information regarding to the user with primary key as emailAddress
     * @return if no conflict in email address than returns the auto increment id of the user
     *  or if there is an user with the same email address return a 409 conflict code
     */
    @RequestMapping(value = "/rest/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser (@RequestBody Person person ,UriComponentsBuilder ucBuilder) {	
    	try {
            Person p = personService.addPerson(person);
            HttpHeaders headers = new HttpHeaders();
       	 	return new ResponseEntity<Person>(p, headers, HttpStatus.CREATED);
        } catch(AccountExistsException exception) {
            throw new ConflictException();
        }
    }
    
    /**
     * Login a login with the given credentials
     * @param person :- Containing the email address and the password
     * @return :- User id for the given credentials
     */
    @RequestMapping(value = "/rest/user/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser (@RequestBody Person person ,UriComponentsBuilder ucBuilder) {	
    	try {
            Person p = personService.getPersonByEmail(person.getEmailAddress());
            if(p == null) {
            	throw new AccountDoesNotExistException();
            } else {
            	if (p.getPassword().equals(person.getPassword())) {
            		 HttpHeaders headers = new HttpHeaders();
                     return new ResponseEntity<Person>(p, headers, HttpStatus.CREATED);
            	} else {
            		PersonErrorInformation pei = new PersonErrorInformation();
                	pei.setDescription("Invalid Credentials");
                	pei.setErrorCode(HttpStatus.UNAUTHORIZED);
                    return new ResponseEntity<PersonErrorInformation>(pei, HttpStatus.UNAUTHORIZED);
            	}
            }
        } catch(AccountDoesNotExistException exception) {
        	PersonErrorInformation pei = new PersonErrorInformation();
        	pei.setDescription("Account doesnt exist");
        	pei.setErrorCode(HttpStatus.NOT_FOUND);
            return new ResponseEntity<PersonErrorInformation>(pei, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/rest/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Person person = personService.getPersonById(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
    
    @ExceptionHandler(ConflictException.class)
	public ResponseEntity<PersonErrorInformation> handleCustomException(ConflictException ex) {
    	// we can write custom code here for the error handling;
    	PersonErrorInformation pei = new PersonErrorInformation();
    	pei.setDescription("Data integrity violation");
    	pei.setErrorCode(HttpStatus.CONFLICT);
        return new ResponseEntity<PersonErrorInformation>(pei, HttpStatus.CONFLICT);
	}

}
