package com.startup.platform.presentation.action;


import com.startup.platform.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractAction {
    public String MESSAGE = "ERROR";
    Factory factory = Factory.getInstance();

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    protected Factory getServiceFactory() {
        return factory;
    }

}
