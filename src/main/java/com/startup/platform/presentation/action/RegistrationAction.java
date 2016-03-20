package com.startup.platform.presentation.action;

import com.startup.platform.dao.UserDao;
import com.startup.platform.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationAction extends AbstractAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        System.out.println("login = " + login);
        System.out.println("password = " + password);
        System.out.println("firstname = " + firstname);
        System.out.println("lastname = " + lastname);


        User newUser = new User();

        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);

        try {
            UserDao userDao = factory.getUserDao();
            userDao.addUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
