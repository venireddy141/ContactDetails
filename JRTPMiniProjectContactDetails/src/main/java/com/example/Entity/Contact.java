package com.example.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CONTACT_DTLS")
public class Contact implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CONTACT_ID")
	@GeneratedValue
	private Integer contactId;
	
	
	
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	

}
