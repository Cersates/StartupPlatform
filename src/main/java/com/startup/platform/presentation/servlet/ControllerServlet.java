package com.startup.platform.presentation.servlet;

import com.startup.platform.presentation.action.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerServlet extends HttpServlet {
    private Map<String, AbstractAction> actionMap;

    @Override
    public void init() throws ServletException {

        actionMap = new HashMap<String, AbstractAction>();
        actionMap.put("login", new LoginAction());
        actionMap.put("signOut", new SignOutAction());
        actionMap.put("allUsers", new AllUsersAction());
        actionMap.put("parse", new ParseAction());
        actionMap.put("registration", new RegistrationAction());
        actionMap.put("connect", new ConnectAction());
        actionMap.put("addAddressToParse", new AddAddressToParseAction());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            System.out.println("---action = " + action);
            actionMap.get(action).execute(req, resp);
        }
    }
}
