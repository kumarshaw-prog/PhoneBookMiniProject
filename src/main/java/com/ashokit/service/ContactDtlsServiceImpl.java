package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactDtlsEntity;
import com.ashokit.exceptions.PhoneBookAppException;
import com.ashokit.modal.Contact;
import com.ashokit.repository.ContactDtlsRepository;


@Service
public class ContactDtlsServiceImpl implements ContactDtlsService {
	
	@Autowired
	ContactDtlsRepository contactdtlsRepository;

	@Override
	public boolean saveContact(Contact c) {
		boolean  isSaved=false;
		
		try {
			
			ContactDtlsEntity entity=new ContactDtlsEntity();
			BeanUtils.copyProperties(c, entity);
			ContactDtlsEntity saveEntity=contactdtlsRepository.save(entity);
//			if(saveEntity.getContactId() !=null) {
//				isSaved=true;
//			}
			
			if ( saveEntity != null ) {
				isSaved=true;	
			}
			
			
		} catch (Exception e) {
			throw new PhoneBookAppException("saved Failed");
		}
	return isSaved;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> listData=null;
		
		try {
			//int i=10/0;
			List<ContactDtlsEntity> entity=contactdtlsRepository.findAll();
			List<Contact> contact=new ArrayList<>();
			for(ContactDtlsEntity e:entity) {
				Contact contacts=new Contact();
				BeanUtils.copyProperties(e, contacts);
				contact.add(contacts);
			}
			
			return contact;
		} catch (Exception e) {
			throw new PhoneBookAppException("saved Failed");
		}
		
		//return contact;
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
