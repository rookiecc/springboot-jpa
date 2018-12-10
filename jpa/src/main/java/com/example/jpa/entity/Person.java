package com.example.jpa.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "t_person")
@Entity
public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7132455621534696025L;

	@Column(name = "name", nullable = true, length = 24)
	private String name;

	@Column(name = "age", nullable = true, length = 4)
	private int age;

	@Column(name = "gender", nullable = true, length = 2)
	private String gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "access_id", referencedColumnName = "id", unique = true)
	private Access access;

//	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.LAZY )
//	@JoinTable(name="t_person_card",
//	           joinColumns= {@JoinColumn(name="p_id")},
//	           inverseJoinColumns= {@JoinColumn(name="c_id")})
	@OneToMany(cascade= {CascadeType.ALL},mappedBy="person")
	private List<Card> cards;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
}
