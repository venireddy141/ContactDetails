package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Contact;
import com.example.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact obj = repo.save(contact);
		/*
		 * if(obj.getContactId()!=null) { return true; } else { return false; }
		 */
		return obj.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
     
		
		return repo.findByActiveSw("Y");
		//return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		/*
		 * Contact obj= repo.save(contact);
		 * 
		 * if(obj.getContactId()!=null) { return true; } else { return false; }
		 * 
		 * return obj.getContactId()!=null;
		 */

		try {
			Contact save = repo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}

	}
	

	@Override
	public boolean deleteContact(Integer contactId) {
		try {
			Contact contact = repo.findById(contactId).get();
			contact.setActiveSw("N");
		repo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}

	}

	/*
	 * @Override public Contact getDeleteById(Integer contactId) {
	 * repo.deleteById(contactId); return null; }
	 */

}
