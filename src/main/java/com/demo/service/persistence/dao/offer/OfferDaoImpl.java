package com.demo.service.persistence.dao.offer;

import com.demo.service.persistence.dao.offer.repository.OfferRepository;
import com.demo.service.persistence.domain.offer.Offer;

import com.demo.service.persistence.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;


@Repository
public class OfferDaoImpl implements OfferDao {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferDaoImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public List<Offer> findAll() throws PersistenceException, DataNotFoundException {
        return offerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public List<Offer> findNonCanceledOffers() throws PersistenceException, DataNotFoundException {
        return offerRepository.findNonCanceledOffers();
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public List<Offer> search(String description) throws PersistenceException, DataNotFoundException {
        if ( description == null ) {
            throw new DataNotFoundException("Offer with description " + description + " does not exist");
        }
        try {
            return offerRepository.search(description);
        } catch (Exception e) {
            throw new DataNotFoundException(e);
        }

    }

    @Override
    @Transactional(readOnly = false , propagation = Propagation.REQUIRED)
    public void batchUpdateCanceledOffers(Date date) throws PersistenceException, DataNotFoundException {
        if ( date == null ) {
            throw new DataNotFoundException("Offer with date is required");
        }
        try {
            offerRepository.batchUpdateCanceledOffers(date);
            offerRepository.flush();
        } catch (Exception e) {
            throw new DataNotFoundException(e);
        }
    }


    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public Offer findById(Long id) throws DataNotFoundException, PersistenceException {
        if ( id == null ) {
            throw new DataNotFoundException("Offer id " + id + " does not exist");
        }
        try {
            return offerRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new DataNotFoundException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public Offer create(Offer offer) throws PersistenceException, PersistenceException {
        if ( offer == null ) {
            throw new IllegalArgumentException("Offer object can not be null");
        }
        return offerRepository.save(offer);
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public Offer update(Offer offer) throws DataNotFoundException, PersistenceException, DataNotFoundException {
        if ( offer == null ) {
            throw new IllegalArgumentException("Offer object can not be null");
        }
        try {
            return offerRepository.saveAndFlush(offer);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public void deleteById(Long id) throws DataNotFoundException, PersistenceException {
        if ( !offerRepository.existsById(id) ) {
            throw new DataNotFoundException("Offer with id " + id + " does not exist");
        }
        try {
            Offer offer = offerRepository.getOne(id);
            offerRepository.delete(offer);
            offerRepository.flush();
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public boolean exists(Long id) throws PersistenceException {
        if ( id == null ) {
            throw new IllegalArgumentException("Offer id can not be null");
        }
        try {
            return offerRepository.existsById(id);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }
}
