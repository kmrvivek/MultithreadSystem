package com.company.intersegrega.service;

import java.util.List;

import com.company.intersegrega.entity.Entity;
import com.company.intersegrega.entity.User;

//common interface to be implemented by all persistence services. 
public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
	//Do not put this method in interface as other class donot implement it
	/*public List<User> findByName(String name);*/
	
}
