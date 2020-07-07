package com.rebati.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebati.entity.ContactEntity;
import com.rebati.model.Contact;
import com.rebati.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity = contactRepository.save(entity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities = contactRepository.findAll();
		List<Contact> contacts = entities.stream().map(entity ->{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		return contacts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById = contactRepository.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c  = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact c) {
		
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
	contactRepository.deleteById(cid);
		return true;
	}

}
