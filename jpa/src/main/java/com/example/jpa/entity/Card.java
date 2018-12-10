package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	
}
