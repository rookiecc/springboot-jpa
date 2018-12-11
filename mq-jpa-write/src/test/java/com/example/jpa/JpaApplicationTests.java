package com.example.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.entity.Access;
import com.example.jpa.entity.BaseEntity;
import com.example.jpa.entity.MQEntity;
import com.example.jpa.entity.Person;
import com.example.jpa.mq.service.MQSenderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

	
    @Autowired
    private MQSenderService<MQEntity<? extends BaseEntity>> mqservice;
	@Test
	public void contextLoads() {
		
		Person p = new Person();
		p.setName("111");
		Access a = new Access();
		a.setAccessName("ddd");
		p.setAccess(a);
	   MQEntity<Person> e = new MQEntity<Person>("person", p);
	   mqservice.send(e);
		
	}

}
