package com.bikkadit.phonebook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bikkadit.phonebook.entity.Contact;


public interface ContactServiceI {
	
	boolean saveContact(Contact contact);
	
	List<Contact> getAllContacts();
	
	Contact getContactById(Integer cid);
	
	boolean deleteContactById(Integer cid);

}
