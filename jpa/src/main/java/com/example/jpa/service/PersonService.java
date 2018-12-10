package com.example.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.jpa.dao.PersonDAO;
import com.example.jpa.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	
	@Transactional
	public void savePerson(Person p) {
		personDAO.save(p);
	}
	
	
	public Person findByAge(Person p) {
		return personDAO.findByAge(p.getAge());
	}
	
	public Person findPersonBySQL(Person p) {
		return personDAO.findPersonBySQL(p.getName());
	}
	
	
	public Page<Object[]> findALLwithPage(Person p,Pageable pageable){
		return personDAO.findALLwithPage(p.getName(), pageable);
	}
	
	
	
}
