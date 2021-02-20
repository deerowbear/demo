package com.demo.model.offer;


import com.demo.service.remote.common.BaseRequest;

import java.util.Date;

public class OfferSearchModel extends BaseRequest {

    private String description;
    private Date expiredDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
