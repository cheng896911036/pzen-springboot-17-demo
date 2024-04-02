package com.pzen.demo.ebeandemo.domain.finder;

import com.pzen.demo.ebeandemo.domain.Address;
import com.pzen.demo.ebeandemo.domain.query.QAddress;
import io.ebean.Finder;

import java.util.Optional;

/**
 * @author pzen
 */

public class AddressFinder extends Finder<Long, Address> {
    /**
     * Construct using the default EbeanServer.
     */
    public AddressFinder() {
        super(Address.class);
    }


    public Optional<Address> byIdOptional(long id) {
        return query().setId(id).findOneOrEmpty();
    }

    public Address findByName(String city) {
        return query().where().eq("city", city).findOne();
    }

    public Address findByOne() {
        return new QAddress().city.isNotNull().findOne();
    }

}
