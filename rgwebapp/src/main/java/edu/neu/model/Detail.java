package edu.neu.model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 *
 */
@Entity
@Table (name = "Detail")
public class Detail {

    //id is the primary key which is used for identifying the column
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String emailAddress;
    private byte[] image;
    private String S3Location;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getS3Location() {
		return S3Location;
	}

	public void setS3Location(String s3Location) {
		S3Location = s3Location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
    
}
