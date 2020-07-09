package com.ashokit.service;

import java.util.List;

import com.ashokit.modal.Contact;

public interface ContactDtlsService {
	
	public boolean saveContact(Contact c);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer cid);
		
	public boolean deleteById(Integer cid);

}
