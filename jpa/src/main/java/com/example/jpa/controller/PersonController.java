package com.example.jpa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Card;
import com.example.jpa.entity.Person;
import com.example.jpa.entity.PersonVO;
import com.example.jpa.service.PersonService;

@RestController
@RequestMapping(value="/person",produces = "application/json; charset=utf-8")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Map<String,Object> savePerson(Person p,@RequestBody List<Card> cards){
		Map<String,Object> responseMsg = new HashMap<>();

		for(Card c:cards) {
			c.setPerson(p);
		}
		p.setCards(cards);
		
		personService.savePerson(p);
		responseMsg.put("code","200");
		responseMsg.put("msg", "保存成功");
		return responseMsg;
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Map<String,Object> updatePerson(Person p){
		Map<String,Object> responseMsg = new HashMap<>();
		personService.savePerson(p);
		responseMsg.put("code","200");
		responseMsg.put("msg", "保存成功");
		return responseMsg;
		
	}
	
	
	
	@RequestMapping(value="/findByAge",method=RequestMethod.GET)
	public PersonVO findByAge(Person p) {
		Person person =  personService.findByAge(p);
		PersonVO vo = new PersonVO();
		vo.setAge(person.getAge());
		vo.setName(p.getName());
		vo.setId(person.getId());
		vo.setCreatTime(person.getCreateDate());
		vo.setModifyTime(person.getUpdateDate());
		return vo;
	}
	
	@RequestMapping(value="/findPersonBySQL",method=RequestMethod.GET)
	public Person findPersonBySQL(Person p) {
		return personService.findPersonBySQL(p);
	}
	
	
	@RequestMapping(value="/findALLwithPage",method=RequestMethod.GET)
	public Page<Object[]> findALLwithPage(Person p,int page,int size){
//		Sort sort = new Sort(Direction.DESC, "id");
		List<Order> orders = new ArrayList<>();
		orders.add(Order.desc("id"));
		orders.add(Order.asc("gender"));

		
		return personService.findALLwithPage(p, PageRequest.of(page-1, size,Sort.by(orders)));
	}
}
