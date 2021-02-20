package com.demo.service.persistence.dao.offer.repository;

import com.demo.service.persistence.domain.offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Transactional
    @Modifying
    @Query("SELECT offer FROM Offer offer where offer.canceled = false")
    public List<Offer> findNonCanceledOffers();

    @Transactional
    public List<Offer> findByDescription(String description);

    @Transactional
    @Modifying
    @Query("SELECT offer FROM Offer offer where lower(offer.description) LIKE :description% AND offer.canceled = false")
    public List<Offer> search(String description);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update Offer offer set offer.canceled = true WHERE offer.expirationDate < :expirationDate")
    public void batchUpdateCanceledOffers(Date expirationDate);

}
