package com.demo.service.modelmapper.offer;


import com.demo.model.offer.OfferModel;
import com.demo.service.modelmapper.BaseModelMapper;
import com.demo.service.persistence.domain.offer.Offer;
import com.demo.util.ModelMapperException;
import com.demo.util.ModelMapper;


public class OfferModelMapper extends BaseModelMapper implements ModelMapper<OfferModel, Offer> {

    @Override
    public OfferModel toModel(Offer domain) throws ModelMapperException {
        OfferModel model = new OfferModel();
        model.setId(domain.getId());
        model.setDescription(domain.getDescription());
        model.setCurrency(domain.getCurrency());
        model.setCanceled(domain.isCanceled());
        model.setExpirationDate(domain.getExpirationDate());
        return model;
    }

    @Override
    public Offer toDomain(OfferModel model) throws ModelMapperException {
        Offer domain = new Offer();
        if(model.getId() != 0) {
            domain.setId(model.getId());
        }
        domain.setDescription(model.getDescription());
        domain.setCurrency(model.getCurrency());
        domain.setExpirationDate(model.getExpirationDate());
        domain.setCanceled(model.isCanceled());
        return domain;
    }
   
}
