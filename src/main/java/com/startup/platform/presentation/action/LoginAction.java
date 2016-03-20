package com.startup.platform.presentation.action;

import com.startup.platform.dao.UserDao;
import com.startup.platform.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginAction extends AbstractAction {

    private final String MESSAGE = "Incorrect login or password";

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        System.out.println("login = " + login);
        System.out.println("password = " + password);
        int userId = 0;

        try {

            UserDao userDao = factory.getUserDao();
            List<User> users = userDao.getUsers();

            for (User user : users) {
                if ((user.getLogin().equals(login)) && (user.getPassword().equals(password))) {
                    HttpSession session = request.getSession();
                    userId = 1;
                    session.setAttribute("userId", userId);
                    System.out.println("userId = " + userId);
                    continue;
                }
            }

            if (userId == 1) {
                request.getRequestDispatcher("/selectParseString.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", MESSAGE);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
