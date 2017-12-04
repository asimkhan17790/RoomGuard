package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import edu.neu.model.Detail;

@Service("detailService")
public class DetailServiceImpl implements DetailService{

	@Override
	public Detail addDetail(Detail d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detail> listDetails(String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
