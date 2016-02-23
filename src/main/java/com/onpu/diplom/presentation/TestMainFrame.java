package com.onpu.diplom.presentation;

import com.onpu.diplom.dao.AddressDao;
import com.onpu.diplom.entity.Address;
import com.onpu.diplom.util.Factory;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TestMainFrame extends JFrame {

    public static void createGUI() throws SQLException {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Factory factory = Factory.getInstance();
        AddressDao addressDao = factory.getAddressDao();
        List<Address> addressess = addressDao.getAddresses();


        String[][] data = new String[addressess.size()][5];

        for (int i = 0; i < addressess.size(); i++) {
            data[i][0] = addressess.get(i).getCountry();
            data[i][1] = addressess.get(i).getRegion();
            data[i][2] = addressess.get(i).getCity();
            data[i][3] = addressess.get(i).getStreet();
            data[i][4] = addressess.get(i).getBuilding();
        }
        String[] columnNames = {
                "country",
                "region",
                "city",
                "street",
                "building"
        };
        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
