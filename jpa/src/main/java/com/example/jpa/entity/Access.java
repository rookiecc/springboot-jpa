package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * 
 * 问题1、No serializer found for class
 * org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer (to avoid
 * exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS)
 * 解决:@JsonIgnoreProperties(value =
 * {"handler","hibernateLazyInitializer","fieldHandler"})
 * https://blog.csdn.net/J080624/article/details/82529082
 * 
 * @author Administrator
 *
 */

@Entity
@Table(name = "t_access")
public class Access extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3748650714163193190L;

	@Column(name = "accessname", nullable = true, length = 100)
	private String accessName;
	

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

}
