package com.bikkadit.phonebook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.phonebook.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable>{
	
	

}
