package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.modal.Contact;
import com.ashokit.service.ContactDtlsServiceImpl;

@Controller
public class ContactInfoController {
	
	@Autowired
	ContactDtlsServiceImpl contactdtlsServiceimpl;
	
	@GetMapping(value= {"/","/addContact"})
	public String loadForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact contact,Model model) {
		boolean isSaved=contactdtlsServiceimpl.saveContact(contact);
		if(isSaved) {
			model.addAttribute("succMsg", "SuccessFull Saved");
		}
		else {
			model.addAttribute("errMsg", "Failed To saved");
		}
		
		return "contactInfo";

}
	
	@GetMapping("/viewContact")
	public String handleViewContactLink(Model model) {
		List<Contact> contactList=contactdtlsServiceimpl.getAllContact();
		model.addAttribute("contacts", contactList);
		return "viewContactInfo";
	}
	
	
}
