package com.example.Service;

import java.util.List;

import com.example.Entity.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public  Contact getContactById(Integer contactId);
	
	public boolean updateContact(Contact contact);
	

	public boolean deleteContact(Integer contactId);
	
	//public  Contact getDeleteById(Integer contactId);

}
