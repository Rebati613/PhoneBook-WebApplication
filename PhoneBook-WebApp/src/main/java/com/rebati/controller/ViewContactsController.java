package com.rebati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebati.model.Contact;
import com.rebati.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid")Integer contactId,Model model) {
		Contact contactById = contactService.getContactById(contactId);
		model.addAttribute("contact", contactById);
		return "contactInfo";
	}
	String updateContact(Contact c, Model model) {
		return null;
		
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid")Integer contactId) {
		boolean isDelete = contactService.deleteContact(contactId);
		if(isDelete) {
			return "redirect:/viewContacts";
		}
		else {
		return null;
		}
	}

}
