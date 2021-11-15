package com.bikkadit.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bikkadit.phonebook.entity.Contact;
import com.bikkadit.phonebook.service.ContactServiceI;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactServiceI contactService;
	
	@GetMapping("/contact")
	private String loadContactForm(Model model) {
		Contact contactobj=new Contact();
		model.addAttribute("contact",contactobj);
		return "contactInfo";
		}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
		boolean isSaved=   contactService.saveContact(contact);
		if(isSaved) {
			model.addAttribute("success","contact saved Successfully");
		}else {
			model.addAttribute("error","Failed to save contact");
		}
		return "contactInfo";
		}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
		List<Contact> allContacts=   contactService.getAllContacts();
		model.addAttribute("contacts",allContacts);
		return "contacts";
		
	}
	
}
