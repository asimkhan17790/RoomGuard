package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import edu.neu.dao.DetailDao;
import edu.neu.dao.DetailDaoImpl;
import edu.neu.dao.PersonDao;
import edu.neu.exception.AccountExistsException;
import edu.neu.model.Detail;
import edu.neu.model.Person;

@Service("detailService")
public class DetailServiceImpl implements DetailService{

	@Autowired
	private DetailDao detailDao;
	
	@Override
	@Transactional
	public Detail addDetail(Detail d) {
		Detail detail = detailDao.addDetail(d);
		return detail;
	}

	@Override
	@Transactional
	public List<Detail> listDetails(String emailAddress) {
		// TODO Auto-generated method stub
		return this.detailDao.listDetails(emailAddress);
	}

}
