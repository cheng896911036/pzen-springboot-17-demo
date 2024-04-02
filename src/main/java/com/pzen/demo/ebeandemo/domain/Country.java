package com.pzen.demo.ebeandemo.domain;

import com.pzen.demo.ebeandemo.domain.finder.CountryFinder;
import io.ebean.Model;
import io.ebean.annotation.Cache;
import io.ebean.annotation.StorageEngine;
import jakarta.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author pzen
 */

@Entity
@Table(name = "country")
@Cache
@StorageEngine("ENGINE = Log()")
public class Country extends Model {

    public static final CountryFinder find = new CountryFinder();

    @Id
    @Size(max = 2)
    final String code;

    @Size(max = 60)
    final String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }


    public String toString() {
        return code;
    }

    /**
     * Return code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Return name.
     */
    public String getName() {
        return name;
    }

}
