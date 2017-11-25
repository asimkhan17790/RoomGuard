package com.dao;

import com.model.Person;
import java.util.List;

public interface PersonDao {
    public void addperson (Person p);
    public void updatePerson (Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
}
