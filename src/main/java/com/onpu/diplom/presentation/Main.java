package com.onpu.diplom.presentation;

import com.onpu.diplom.dao.AddressDao;
import com.onpu.diplom.entity.Address;
import com.onpu.diplom.util.Factory;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Factory factory = Factory.getInstance();

        AddressDao addressDao = factory.getAddressDao();

//        Address newAddress = new Address();
//        newAddress.setCountry("country11");
//        newAddress.setRegion("region11");
//        newAddress.setCity("city11");
//        newAddress.setStreet("street11");
//        newAddress.setBuilding("building11");
//        addressDao.addAddres(newAddress);
//        List<Address> addresses = addressDao.getAddresses();
//        for (Address address : addresses) {
//            System.out.println(address);
//        }
//        addressDao.deleteAddress(newAddress);

        List<Address> addressess = addressDao.getAddresses();
        for (Address address : addressess) {
            System.out.println(address);
        }


        System.exit(0);

    }

}
