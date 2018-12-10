package com.example.jpa.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.jpa.dao.PersonDAO;
import com.example.jpa.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private RedisService redisService;

	private static String key = "person_";

	@Transactional
	public void savePerson(Person p) {
		personDAO.save(p);
		this.setCache(p);
	}

	public Person findByAge(Person p) {
		String value = (String) redisService.getValue(key + p.getId() + "_");
		if (value == null || "".equals(value)) {
			Person dbp = personDAO.findByAge(p.getAge());
			this.setCache(dbp);
			return dbp;
		} else {
			Person cacheP = JSON.parseObject(value, Person.class);
			return cacheP;
		}
	}

	public Person findPersonBySQL(Person p) {
		return personDAO.findPersonBySQL(p.getName());
	}

	public Page<Object[]> findALLwithPage(Person p, Pageable pageable) {
		return personDAO.findALLwithPage(p.getName(), pageable);
	}

	public Person findById(Long id) {
		String value = (String) redisService.getValue(key + id + "_");
		if (value == null || "".equals(value)) {
			Optional<Person> op = personDAO.findById(id);
			this.setCache(op.get());
			return op.get();
		} else {
			Person cacheP = JSON.parseObject(value, Person.class);
			return cacheP;
		}
	}

	private void setCache(Person p) {
		if (p != null) {
			redisService.setValue(key + p.getId() + "_", p.toString());
		}
	}

}
