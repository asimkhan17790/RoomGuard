package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.dao.PersonDao;
import edu.neu.exception.AccountExistsException;
import edu.neu.model.Person;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	@Transactional
	public Person addPerson(Person person1) {
		Person person = personDao.findAccountByEmail(person1.getEmailAddress());
		if (person != null) {
			throw new AccountExistsException();
		}
		return personDao.addperson(person1);
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
