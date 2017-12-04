package edu.neu.dao;

import java.util.List;
import edu.neu.model.Detail;

public interface DetailDao {
	public Detail addDetail(Detail d);
	public List<Detail> listDetails(String emailAddress);

}
