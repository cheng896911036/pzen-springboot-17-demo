package com.pzen.demo.ebeandemo;

import com.pzen.demo.ebeandemo.domain.Address;
import com.pzen.demo.ebeandemo.domain.Country;
import io.ebean.DB;
import io.ebean.Database;

import java.util.List;

/**
 * @author pzen
 */

public class EbeanMain {

    public static void main(String[] args) {
        Database db = DB.getDefault();
        //插入数据
        Address address = new Address();
        address.setCity("北京");
        Country contry = new Country("001", "朝阳区");
        address.setCountry(contry);
        if (db.find(Address.class).where().eq("city", "北京").findCount() == 0) {
            address.save();
            contry.save();
        }
        //查询全部信息
        List<Address> addressList = db.find(Address.class).findList();
        System.out.println("addressListAll: " + addressList);
        //条件查询
        List<Address> addressListForCity = db.find(Address.class).where().eq("city", "北京").findList();
        System.out.println("addressListForCity: " + addressListForCity);

        System.out.println("done");


    }

}
