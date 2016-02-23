package com.onpu.diplom.dao;

import com.onpu.diplom.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

    public void addAddres(Address address) throws SQLException;

    public void deleteAddress(Address address) throws SQLException;

    public Address getAddress(int id) throws SQLException;

    public List<Address> getAddresses() throws SQLException;

}
