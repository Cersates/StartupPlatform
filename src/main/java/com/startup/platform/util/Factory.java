package com.startup.platform.util;


public class Factory {

    private static Factory instance = new Factory();
//    private AddressDao addressDao;

    private Factory() {
    }

    public static Factory getInstance() {
        return Factory.instance;
    }

//    public AddressDao getAddressDao() {
//        if (addressDao == null) {
//            addressDao = new AddressDaoImpl();
//        }
//        return addressDao;
//    }
}
