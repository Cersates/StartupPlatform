package com.startup.platform.presentation.action;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutAction extends AbstractAction {

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        session.setAttribute("userId", null);

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
