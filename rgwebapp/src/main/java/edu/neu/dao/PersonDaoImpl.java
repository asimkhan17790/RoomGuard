package edu.neu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.neu.model.Person;

import javax.annotation.Resource;
import java.util.List;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    @Resource(name="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    // TODO Implement the exception and error handling in a better way
    @Override
    public Person addperson(Person p) {
    	try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(p);	
            return p;
    	}
    	catch (Exception e) {
    		System.out.println("Some exception occured" + e.getStackTrace());
    	}
    	// should return an error rather than the person here
    	// discuss with Asim how to handle this for now returning null
		return null;
    }

    @Override
    public void updatePerson(Person p) {

    }

    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = (List<Person>) session.createQuery("from Person").list();
        return personsList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.get(Person.class, new Integer(id));
        return p;
    }

    @Override
    public void removePerson(int id) {

    }
}
