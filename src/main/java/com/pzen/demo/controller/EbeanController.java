package com.pzen.demo.controller;

import com.pzen.demo.ebeandemo.domain.Address;
import com.pzen.demo.ebeandemo.domain.Country;
import com.pzen.demo.ebeandemo.domain.query.QAddress;
import com.pzen.demo.ebeandemo.domain.query.QCountry;
import io.ebean.DB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pzen
 */
@RestController
public class EbeanController {
    @GetMapping("/addressList")
    public List addressList() {
        //查询全部信息
        List<Address> addressList = DB.getDefault().find(Address.class).findList();
        //提示报错不要紧，只需要Maven compile下即可
        List<Address> addressList1 = new QAddress().findList();
        return addressList1;
    }

    @GetMapping("/addressList2")
    public List addressList2() {
        //查询全部信息
        List<Country> countryList = DB.getDefault().find(Country.class).findList();
        //提示报错不要紧，只需要Maven compile下即可
        List<Country> countryList1 = new QCountry().findList();
        return countryList1;
    }


}
