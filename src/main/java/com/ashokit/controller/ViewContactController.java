package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.modal.Contact;
import com.ashokit.service.ContactDtlsServiceImpl;

@Controller
public class ViewContactController {
	
	@Autowired
	ContactDtlsServiceImpl contactdtlsServiceimpl;
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cId") Integer contactId, Model model) {
		Contact c=contactdtlsServiceimpl.getContactById(contactId);
	    model.addAttribute("contact", c);
		return "contactInfo";
	}
      
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("contactId") Integer contactId) {
		boolean isDelete=contactdtlsServiceimpl.deleteById(contactId);
		if(isDelete) {
			return "redirect:/viewContact";
		}
		return null;
	}
}
