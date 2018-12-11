package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="t_card")
public class Card  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1934993896466309945L;
	
	@Column(name="card_number")
	private String cardNumber;

	@ManyToOne()
	@JoinColumn(name="person_fk")
	@JSONField(serialize=false)  
	private Person person;
	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
