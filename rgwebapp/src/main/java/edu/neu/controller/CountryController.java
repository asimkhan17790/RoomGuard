package edu.neu.controller;
 
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class CountryController {
 
 @Autowired
 private HttpServletRequest request;

 
 @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
 public List<String> getCountries() {
  
  List<String> listOfCountries = new ArrayList<String>();
  listOfCountries.add("India");
  listOfCountries.add("US");
  listOfCountries.add("Russia");
  listOfCountries.add("China");
  listOfCountries.add("Sri Lanka");
  listOfCountries.add("Canada");
  return listOfCountries;
 	}
 
 } 
