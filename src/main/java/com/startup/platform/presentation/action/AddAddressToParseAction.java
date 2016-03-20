package com.startup.platform.presentation.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAddressToParseAction extends AbstractAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String address = request.getParameter("address");
        String dateAdd = request.getParameter("dateAdd");
        String userId = "1";

        System.out.println("login = " + address);
        System.out.println("password = " + dateAdd);
        System.out.println("firstname = " + userId);

        request.getRequestDispatcher("/selectParseString.jsp").forward(request, response);
    }
}
