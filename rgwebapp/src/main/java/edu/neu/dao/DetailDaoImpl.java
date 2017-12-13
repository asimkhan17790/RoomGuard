package edu.neu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.neu.model.Detail;
import edu.neu.model.Person;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;

@Repository("detailDao")
public class DetailDaoImpl implements DetailDao{

	@Resource(name="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public Detail addDetail(Detail d) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	session.persist(d);	
        return d;
	}

	@Override
	public List<Detail> listDetails(String emailAddress) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Detail where emailAddress = :code ");
        query.setParameter("code", emailAddress);
        List<Detail> listOfPerson = query.list();
        if(listOfPerson.size() == 0) {
            return null;
        } else {
            return listOfPerson;
        }
	}
}
