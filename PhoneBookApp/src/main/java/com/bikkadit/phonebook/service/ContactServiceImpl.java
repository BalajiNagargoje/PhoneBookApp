package com.bikkadit.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.phonebook.entity.Contact;
import com.bikkadit.phonebook.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactServiceI {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
	Contact	save=contactRepository.save(contact);
	if(save !=null && save.getContactId()!=null) {
		return true;
	}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> findAll = contactRepository.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<Contact>findById=contactRepository.findById(cid);
		if(findById.isPresent()) {
			Contact contact=  findById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		boolean status=contactRepository.existsById(cid);
		if(status) {
			contactRepository.deleteById(cid);
			return true;
		}
		return false;
	}

}
