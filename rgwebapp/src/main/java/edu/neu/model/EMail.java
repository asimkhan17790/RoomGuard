package edu.neu.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class EMail implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
    private MultipartFile image;
	
    
    public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
    
    
    

}
