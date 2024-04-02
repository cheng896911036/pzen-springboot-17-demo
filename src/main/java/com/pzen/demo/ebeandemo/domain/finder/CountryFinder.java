package com.pzen.demo.ebeandemo.domain.finder;

import com.pzen.demo.ebeandemo.domain.Country;
import io.ebean.Finder;

/**
 * @author pzen
 */

public class CountryFinder extends Finder<String, Country> {

    /**
     * Construct using the default EbeanServer.
     */
    public CountryFinder() {
        super(Country.class);
    }

}
