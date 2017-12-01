package edu.neu.service;

import java.util.List;

import edu.neu.model.Person;

public interface PersonService {
    public Person addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);

}
