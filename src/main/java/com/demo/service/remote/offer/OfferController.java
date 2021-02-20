package com.demo.service.remote.offer;

import com.demo.model.offer.OfferModel;
import com.demo.service.local.offer.OfferLocalService;
import com.demo.service.remote.BaseRemoteServiceController;
import com.demo.model.offer.OfferSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("v1.OfferController")
@RequestMapping("/ws/v1/offer")
public class OfferController extends BaseRemoteServiceController {

    @Autowired
    OfferLocalService offerLocalService;

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OfferModel> list(@RequestParam(required = false) Boolean canceled)  throws Exception {
        return offerLocalService.list();
    }

    @RequestMapping(value = { "/search" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OfferModel> search(@RequestBody OfferSearchModel offerSearchModel) throws Exception  {
        return offerLocalService.search(offerSearchModel);
    }

    @RequestMapping(value = { "/add" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public OfferModel add(@RequestBody OfferModel offerModel) throws Exception {
        return offerLocalService.add(offerModel);
    }

    @RequestMapping(value = { "/update/{id}" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public OfferModel update(@PathVariable long id, @RequestBody OfferModel offerModel) throws Exception {
        return offerLocalService.update(id, offerModel);
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable long id)  throws Exception {
        offerLocalService.delete(id);
    }

    @RequestMapping(value = { "/cancel/{id}" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public OfferModel cancel(@PathVariable long id)  throws Exception {
        return offerLocalService.cancel(id);
    }


}
