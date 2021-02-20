package com.demo.service.local.offer;

import com.demo.model.offer.OfferModel;
import com.demo.model.offer.OfferSearchModel;
import com.demo.service.modelmapper.offer.OfferModelMapper;
import com.demo.service.persistence.dao.offer.OfferDao;
import com.demo.service.persistence.domain.offer.Offer;
import com.demo.service.persistence.exception.DataNotFoundException;
import com.demo.service.persistence.exception.LocalServiceException;
import com.demo.util.ModelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

@Service
public class OfferLocalServiceImpl implements OfferLocalService {

    private static final Logger LOG = Logger.getLogger(OfferLocalService.class.getName());

    @Autowired
    OfferDao offerDao;

    @Override
    public List<OfferModel> list() throws LocalServiceException {
        this.cancelOffers();
        try {
            List<Offer> offers = offerDao.findNonCanceledOffers();
            return ModelUtils.toModels(offers, OfferModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public OfferModel findById(long id) throws LocalServiceException {
        try {
            Offer offer = offerDao.findById(id);
            return ModelUtils.toModel(offer, OfferModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public List<OfferModel> search(OfferSearchModel offerSearchModel) throws LocalServiceException {
        try {
            return ModelUtils.toModels(offerDao.search(offerSearchModel.getDescription().toLowerCase()), OfferModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public OfferModel add(OfferModel offerModel) throws LocalServiceException {
        Offer offer = ModelUtils.toDomain(offerModel, OfferModelMapper.class);
        return ModelUtils.toModel(offerDao.create(offer), OfferModelMapper.class);
    }

    @Override
    public OfferModel update(long id, OfferModel offerModel) throws LocalServiceException {
        try {
            OfferModel updateOfferModel = this.findById(id);
            updateOfferModel.setCanceled(offerModel.isCanceled());
            updateOfferModel.setPrice(offerModel.getPrice());
            updateOfferModel.setDescription(offerModel.getDescription());
            updateOfferModel.setCurrency(offerModel.getCurrency());
            Offer offer = ModelUtils.toDomain(updateOfferModel, OfferModelMapper.class);
            return ModelUtils.toModel(offerDao.update(offer), OfferModelMapper.class);
        } catch (PersistenceException | DataNotFoundException ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public void delete(long id) throws LocalServiceException {
        try {
            offerDao.deleteById(id);
        } catch (PersistenceException | DataNotFoundException ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public OfferModel cancel(long id) throws LocalServiceException {
        OfferModel offerModel = this.findById(id);
        offerModel.setCanceled(Boolean.TRUE);
        return this.update(id, offerModel);
    }

    private void cancelOffers() throws LocalServiceException {
        //LocalDate localDate = LocalDate.now();
        try {
            offerDao.batchUpdateCanceledOffers(new Date());
        } catch (PersistenceException | DataNotFoundException ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

}
