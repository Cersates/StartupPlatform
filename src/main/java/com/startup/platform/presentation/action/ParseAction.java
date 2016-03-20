package com.startup.platform.presentation.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParseAction extends AbstractAction {

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for (String s : req.getParameterValues("addrlist")) {
            System.out.println("addrlist = " + s);
        }

        req.getRequestDispatcher("/parseResult.jsp").forward(req, resp);
    }
}
