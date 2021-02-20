package com.demo.service.local.offer;

import com.demo.model.offer.OfferModel;
import com.demo.model.offer.OfferSearchModel;
import com.demo.service.persistence.exception.LocalServiceException;

import java.util.List;


public interface OfferLocalService {

    public List<OfferModel> list() throws LocalServiceException;

    public OfferModel findById(long id) throws LocalServiceException;

    public List<OfferModel> search(OfferSearchModel offerSearchModel) throws LocalServiceException;

    public OfferModel add(OfferModel offerModel) throws LocalServiceException;

    public OfferModel update(long id, OfferModel offerModel) throws LocalServiceException;

    public void delete(long id) throws LocalServiceException;

    public OfferModel cancel(long id) throws LocalServiceException;

}
