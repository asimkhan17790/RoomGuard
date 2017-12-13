package edu.neu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.neu.model.Person;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    @Resource(name="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    // TODO Implement the exception and error handling in a better way
    @Override
    public Person addperson(Person p) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	session.persist(p);	
        return p;
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
    
    @Override
	public Person findAccountByEmail(String emailAddress) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person where emailAddress = :code ");
        query.setParameter("code", emailAddress);
        List<Person> listOfPerson = query.list();
        if(listOfPerson.size() == 0) {
            return null;
        } else {
            return listOfPerson.get(0);
        }
	}
    
}
