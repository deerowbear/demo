package com.demo.service.persistence.domain.offer;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="OFFER")
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name="currency")
    private String currency;

    @Column(name="price")
    private Integer price;

    @Column(name="expirationDate")
    private Date expirationDate;

    @Column(name="canceled")
    private boolean canceled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Offer other = (Offer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("com.demo.service.persistence.domain.offer.Offer[ id=" + id);
        sb.append("\n description = ").append(description);
        sb.append("\n currency = ").append(currency);
        sb.append("\n price = ").append(price);
        sb.append("\n expirationDate = ").append(expirationDate);
        sb.append("\n canceled = ").append(canceled);
        sb.append(" ]");
        return sb.toString();
    }


}
