package com.example.jpa.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.jpa.dao.PersonDAO;
import com.example.jpa.entity.MQEntity;
import com.example.jpa.entity.Person;
import com.example.jpa.mq.service.MQSenderService;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private MQSenderService<MQEntity<Person>>  mqSenderService;
//
//	@Autowired
//	private RedisService<?, String> redisService;

	private static String key = "person_";
	


	@Transactional
	public void savePerson(Person p) {
		personDAO.save(p);
		MQEntity<Person> mq = new MQEntity<Person>(key + p.getId() + "_",p);
		mqSenderService.send(mq);
	}

	public Person findByAge(Person p) {
//		String value = (String) redisService.getValue(key + p.getId() + "_");
//		if (value == null || "".equals(value)) {
//			Person dbp = personDAO.findByAge(p.getAge());
//			this.setCache(dbp);
//			return dbp;
//		} else {
//			Person cacheP = JSON.parseObject(value, Person.class);
//			return cacheP;
//		}
		
		Person dbp = personDAO.findByAge(p.getAge());
		
		return dbp;
	}

	public Person findPersonBySQL(Person p) {
		return personDAO.findPersonBySQL(p.getName());
	}

	public Page<Object[]> findALLwithPage(Person p, Pageable pageable) {
		return personDAO.findALLwithPage(p.getName(), pageable);
	}

	public Person findById(Long id) {
		return null;
//		String value = (String) redisService.getValue(key + id + "_");
//		if (value == null || "".equals(value)) {
//			Optional<Person> op = personDAO.findById(id);
//			this.setCache(op.get());
//			return op.get();
//		} else {
//			Person cacheP = JSON.parseObject(value, Person.class);
//			return cacheP;
//		}
	}



}
