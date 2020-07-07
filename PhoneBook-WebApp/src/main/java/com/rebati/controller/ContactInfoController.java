package com.rebati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rebati.model.Contact;
import com.rebati.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/addContact")
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";
		}
	@PostMapping(value = "/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact")Contact c, Model model) {
		boolean isSaved = contactService.saveContact(c);
		if(isSaved) {
		model.addAttribute("sucMsg", "Contact Saved");
		}
		else {
		model.addAttribute("errMsg", "Failed to save contact");	
		}
		return "contactInfo";
	}
	@GetMapping("/viewContacts")
	String handleViewContactsLink(Model model) {
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewContacts";
		}

}
