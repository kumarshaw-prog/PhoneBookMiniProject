package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactDtlsEntity;
import com.ashokit.modal.Contact;
import com.ashokit.repository.ContactDtlsRepository;


@Service
public class ContactDtlsServiceImpl implements ContactDtlsService {
	
	@Autowired
	ContactDtlsRepository contactdtlsRepository;

	@Override
	public boolean saveContact(Contact c) {
		ContactDtlsEntity entity=new ContactDtlsEntity();
		BeanUtils.copyProperties(c, entity);
		ContactDtlsEntity saveEntity=contactdtlsRepository.save(entity);
		
		return saveEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactDtlsEntity> entity=contactdtlsRepository.findAll();
		List<Contact> contact=new ArrayList<Contact>();
		//Contact contacts=new Contact();
		for(ContactDtlsEntity e:entity) {
			Contact contacts=new Contact();
			BeanUtils.copyProperties(e, contacts);
			/*contacts.setContactName(e.getContactName());
			contacts.setContactEmail(e.getContactEmail());
			contacts.setContactNumber(e.getContactNumber());*/
			contact.add(contacts);
		}
		
		return contact;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDtlsEntity> findById = contactdtlsRepository.findById(cid);
		if(findById.isPresent()) {
			ContactDtlsEntity entity=findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

	@Override
	public boolean deleteById(Integer cid) {
          contactdtlsRepository.deleteById(cid);
		return true;
	}

}
