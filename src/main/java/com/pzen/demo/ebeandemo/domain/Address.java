package com.pzen.demo.ebeandemo.domain;

import com.pzen.demo.ebeandemo.BaseModel;
import com.pzen.demo.ebeandemo.domain.finder.AddressFinder;
import io.ebean.annotation.Cache;
import io.ebean.annotation.StorageEngine;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 * @author pzen
 */

@Entity
@Table(name = "address")
@Cache
@StorageEngine("ENGINE = Log()")
public class Address extends BaseModel {

    public static final AddressFinder find = new AddressFinder();

    @Size(max = 100)
    private String line1;

    @Size(max = 100)
    private String line2;

    @Size(max = 100)
    private String city;

    @ManyToOne
    private Country country;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
