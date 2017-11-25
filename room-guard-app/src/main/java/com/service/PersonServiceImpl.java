package com.service;

import com.dao.PersonDao;
import com.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDAO) {
        this.personDao = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDao.addperson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        this.personDao.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }
}
