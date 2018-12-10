package com.example.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Person;

@Repository
public interface PersonDAO  extends CrudRepository<Person, Long>{

	/**
	* 根据年纪查询用户
	* @param age
	* @return
	*/
	Person findByAge(Integer age);
	
	
	/**
	* 根据年纪和姓名查询
	* @param name
	* @param age
	* @return
	*/
	Person findByNameAndAge(String name, Integer age);
	
	
	
	/**
     * 对于复杂查询可以使用@Query 编写sql
     * @param name
     * @return
     */
    @Query("from Person p where p.name=:name")
    Person findPersonBySQL(@Param("name") String name);
    
    
    @Query(value = "select * from t_person p ",
    	   countQuery = "select count(1) from t_person",
    	   nativeQuery =true
    	   )
    Page<Object[]> findALLwithPage(@Param("name") String name, Pageable pageable);
}
