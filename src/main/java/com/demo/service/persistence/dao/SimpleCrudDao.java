package com.demo.service.persistence.dao;


import com.demo.service.persistence.exception.DataNotFoundException;

import javax.persistence.PersistenceException;


public interface SimpleCrudDao<T, U> {
	public T findById(U id) throws DataNotFoundException, PersistenceException;

	public T create(T domainObj) throws PersistenceException, PersistenceException;
	
	public T update(T domainObj) throws DataNotFoundException, PersistenceException, DataNotFoundException;
	
	public void deleteById(U id) throws DataNotFoundException, PersistenceException;

	public boolean exists(U id) throws PersistenceException;
}
