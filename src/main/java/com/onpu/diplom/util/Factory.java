package com.onpu.diplom.util;

import com.onpu.diplom.dao.AddressDao;
import com.onpu.diplom.dao.impl.AddressDaoImpl;

public class Factory {

    private static Factory instance = new Factory();
    private AddressDao addressDao;

    private Factory() {
    }

    public static Factory getInstance() {
        return Factory.instance;
    }

    public AddressDao getAddressDao() {
        if (addressDao == null){
            addressDao = new AddressDaoImpl();
        }
        return addressDao;
    }

}
