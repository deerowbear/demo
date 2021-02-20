package com.demo.service.persistence.dao.offer;

import com.demo.service.persistence.dao.SimpleCrudDao;
import com.demo.service.persistence.domain.offer.Offer;
import com.demo.service.persistence.exception.DataNotFoundException;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public interface OfferDao extends SimpleCrudDao<Offer, Long> {

    public List<Offer> findAll() throws PersistenceException, DataNotFoundException;

    public List<Offer> findNonCanceledOffers() throws PersistenceException, DataNotFoundException;

    public List<Offer> search(String description) throws PersistenceException, DataNotFoundException;

    public void batchUpdateCanceledOffers(Date date) throws PersistenceException, DataNotFoundException;


}
