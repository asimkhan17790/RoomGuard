package edu.neu.service;
import java.util.List;
import edu.neu.model.Detail;

public interface DetailService {
	public Detail addDetail(Detail d);
    public List<Detail> listDetails(String emailAddress);
}
