package com.company.dictionaries.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|title")
@Table(name = "DICTIONARIES_CUSTOMER")
@Entity(name = "dictionaries$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -741949730122741945L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    protected DictionaryValue country;

    @Column(name = "TITLE")
    protected String title;

    public void setCountry(DictionaryValue country) {
        this.country = country;
    }

    public DictionaryValue getCountry() {
        return country;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}