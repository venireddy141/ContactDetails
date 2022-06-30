package com.example.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	
	public List<Contact>  findByActiveSw(String activeSw);
}
