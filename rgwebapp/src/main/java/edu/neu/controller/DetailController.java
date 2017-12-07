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

import com.fasterxml.jackson.core.JsonParser;

import edu.neu.exception.AccountDoesNotExistException;
import edu.neu.exception.AccountExistsException;
import edu.neu.exception.ConflictException;
import edu.neu.exception.PersonErrorInformation;
import edu.neu.model.Detail;
import edu.neu.model.Person;
import edu.neu.service.DetailService;

import java.io.IOException;
import java.util.List;

@RestController
public class DetailController {

    @Autowired
    private DetailService detailService;

    @RequestMapping(value = "/rest/detail", method = RequestMethod.POST)
    public ResponseEntity<?> createDetail (@RequestParam("file") MultipartFile[] uploadFiles, @RequestParam("emailAddress") String emailAddress, UriComponentsBuilder ucBuilder) throws IOException {	
    	try {
    		Detail temp = new Detail();
    		temp.setEmailAddress(emailAddress);
    		temp.setImage(uploadFiles[0].getBytes());
            Detail d = detailService.addDetail(temp);
            HttpHeaders headers = new HttpHeaders();
       	 	return new ResponseEntity<Detail>(d, headers, HttpStatus.CREATED);
        } catch(AccountExistsException exception) {
            throw new ConflictException();
        }
    }
    
    @RequestMapping(value = "/rest/getDetails", method = RequestMethod.GET)
    public ResponseEntity<?> getUserDetail(@RequestParam("emailAddress") String emailAddress, UriComponentsBuilder ucBuilder) {
        List<Detail> details = detailService.listDetails(emailAddress);
        return new ResponseEntity<List<Detail>>(details, HttpStatus.OK);
    }
    
//    By using below method we can get an object directly without mapping to the POJO
//    @RequestMapping(value = "/rest/dummy", method = RequestMethod.POST)
//    public String save(@RequestBody String json){
//    	System.out.println(json);
//    	return "success";
//    }

}
