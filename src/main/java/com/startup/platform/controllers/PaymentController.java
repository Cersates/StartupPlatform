package com.startup.platform.controllers;

import com.startup.platform.model.Payment;
import com.startup.platform.model.Project;
import com.startup.platform.model.User;
import com.startup.platform.service.PaymentService;
import com.startup.platform.service.ProjectService;
import com.startup.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired(required = true)
    private PaymentService paymentService;

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private ProjectService projectService;

    User userSession = new User(-1);

    @RequestMapping(value = "/")
    public String root() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        userSession = new User(-1);
        return "/login.jsp";
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User userInp, Model model) {

        List<User> allUsers = userService.getAll();
        for (User user : allUsers) {
            if ((user.getLogin().equals(userInp.getLogin())) &&
                    (user.getPassword().equals(userInp.getPassword()))) {
                userSession = user;
//                model.addAttribute("userId", user.getId());
                System.out.println("userId = " + userSession.getId());
                return "redirect:homeUser";
            }
        }

        return "redirect:login";
    }

    @RequestMapping(value = "/registration")
    public String registration(Model model) {
        return "/registration.jsp";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user) {
        userService.add(user);
        System.out.println("(registration) new user: " + user);
        return "redirect:login";
    }

    @RequestMapping(value = "/homeUser")
    public String homeUser(Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }
        model.addAttribute("projectList", userSession.getProjects());
        return "/homeUser.jsp";
    }

    @RequestMapping(value = "/homeUser/{id}", method = RequestMethod.GET)
    public String getProject(@PathVariable("id") int id, Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }


        for (Project project : userSession.getProjects()) {
            if (project.getId() == id) {
                model.addAttribute("info", project);
            }
        }

        model.addAttribute("projectList", userSession.getProjects());

        return "/homeUser.jsp";
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.GET)
    public String addProject() {

        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }
        return "addProject.jsp";
    }

    @ModelAttribute("project")
    public Project getProject() {
        return new Project();
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }
        project.setUser(userSession);
        projectService.add(project);
        System.out.println("(add) new project: " + project);
        return "redirect:homeUser";
    }


    //================================================================
    @RequestMapping(value = "/payments")
    public String allPayments(Model model) {
        model.addAttribute("payments", paymentService.getPayments());
        return "payments.jsp";
    }

    @RequestMapping(value = "/add-payment", method = RequestMethod.GET)
    public String addPayment() {
        return "add-payment.jsp";
    }

    @ModelAttribute("payment")
    public Payment newPayment() {
        return new Payment();
    }

    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("payment") Payment payment) {
        paymentService.addPayment(payment);
        return "redirect:payments";
    }

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET)
    public String getPayment(@PathVariable("id") long id, Model model) {
        model.addAttribute("payment", paymentService.get(id));
        return "/payment.jsp";
    }

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET, headers = {"content-type=application/xml"})
    @ResponseBody
    public Payment getPayment(@PathVariable("id") long id) {
        return paymentService.get(id);
    }


}