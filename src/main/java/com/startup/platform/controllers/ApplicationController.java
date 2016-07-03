package com.startup.platform.controllers;

import com.startup.platform.model.Project;
import com.startup.platform.model.User;
import com.startup.platform.service.ProjectService;
import com.startup.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
@SessionAttributes("userSession")
public class ApplicationController {

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private ProjectService projectService;

    User userSession;

    @RequestMapping(value = "/")
    public String root() {

        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        userSession = null;
//        session.setAttribute("userSession", userSession);
//        session.setAttribute("userSession", null);

//        status.setComplete();
        session.removeAttribute("userSession");
        status.setComplete();
//        request.removeAttribute("userSession", WebRequest.SCOPE_SESSION);
//        store.cleanupAttribute(request, "userSession");

//        if (session.getAttribute("userSession") == null) {
//            System.out.println("userSession is null");
//        } else {
//            System.out.println("userSession is not null");
//        }
        return "redirect:/login";
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User userInp, Model model, HttpSession session) {

        List<User> allUsers = userService.getAll();
        for (User user : allUsers) {
            if ((user.getEmail().equals(userInp.getEmail())) &&
                    (user.getPassword().equals(userInp.getPassword()))) {
                userSession = user;
                session.setAttribute("userSession", userSession);
//                session.removeAttribute("userSession");
                session.removeAttribute("message");
//                model.addAttribute("userId", user.getId());
                return "redirect:homeUser";
            }
        }
        session.setAttribute("message", "Incorrect login or password");
        return "redirect:login";
    }

    @RequestMapping(value = "/registration")
    public String registration(Model model) {
        return "/registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user) {
        user.setRegistrationDate(new Date());
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
        model.addAttribute("fav", userSession.getFavorites());
        return "/homeUser";
    }

    @RequestMapping(value = "/homeUser/{id}", method = RequestMethod.GET)
    public String getProject(@PathVariable("id") int id, Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:../login";
        }

        userSession = userService.getById(userSession.getId());
        for (Project project : userSession.getProjects()) {
            if (project.getId() == id) {
                model.addAttribute("info", project);
            }
        }

        model.addAttribute("projectList", userSession.getProjects());

        return "/homeUser";
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.GET)
    public String addProject() {

        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }
        return "addProject";
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
        project.setDateRegistration(new Date());
        projectService.add(project);
        userSession = userService.getById(userSession.getId());
        System.out.println("(add) new project: " + project);
        return "redirect:homeUser";
    }

    @RequestMapping(value = "/search-project", method = RequestMethod.GET)
    public String searchProject() {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }
        return "search";
    }

    //    @ModelAttribute("project")
//    public Project getProject() {
//        return new Project();
//    }
    @RequestMapping(value = "/search-result", method = RequestMethod.POST)
    public String searchProject(@ModelAttribute("project") Project projectParam, Model model,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "dateRegistrationFrom") String dateRegistrationFromStr,
                                @RequestParam(value = "dateRegistrationTo") String dateRegistrationToStr,
                                @RequestParam(value = "financingFrom") BigInteger financingFrom,
                                @RequestParam(value = "financingTo") BigInteger financingTo,
                                @RequestParam(value = "sphere") String sphere
    ) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }

        System.out.println("======= title " + title);
        System.out.println("======= dateRegistrationFromStr " + dateRegistrationFromStr);
        System.out.println("======= dateRegistrationToStr " + dateRegistrationToStr);
        System.out.println("======= financingFrom " + financingFrom);
        System.out.println("======= financingTo " + financingTo);
        System.out.println("======= sphere " + sphere);

        List<Project> projects = projectService.getAll();
        List<Project> projectList;

        projectList = new LinkedList<>(projects);
        if (!title.isEmpty()) {
            for (Project project : projectList) {
                if (!project.getTitle().contains(title)) {
                    projects.remove(project);
                }
                if (projects.isEmpty()) {
                    model.addAttribute("resultSearch", projects);
                    return "search";
                }
            }
        }

        projectList = new LinkedList<>(projects);
        Date dateRegistrationFrom = null;
        Date dateRegistrationTo = null;
        if (!((dateRegistrationFromStr.isEmpty()) || (dateRegistrationToStr.isEmpty()))) {
            try {
                dateRegistrationFrom = new SimpleDateFormat("MM/dd/yyyy").parse(dateRegistrationFromStr);
                dateRegistrationTo = new SimpleDateFormat("MM/dd/yyyy").parse(dateRegistrationToStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (Project project : projectList) {
                boolean b1 = project.getDateRegistration().after(dateRegistrationFrom);
                boolean b2 = project.getDateRegistration().before(dateRegistrationTo);

                if (!(b1 && b2)) {
                    projects.remove(project);
                }
                if (projects.isEmpty()) {
                    model.addAttribute("resultSearch", projects);
                    return "search";
                }
            }
        }

        projectList = new LinkedList<>(projects);
        if (!(financingFrom == null)) {
            for (Project project : projectList) {
                if (project.getFinancing().compareTo(financingFrom) == -1) {
                    projects.remove(project);
                }
                if (projects.isEmpty()) {
                    model.addAttribute("resultSearch", projects);
                    return "search";
                }
            }
        }

        projectList = new LinkedList<>(projects);
        if (!(financingTo == null)) {
            for (Project project : projectList) {
                if (project.getFinancing().compareTo(financingTo) == 1) {
                    projects.remove(project);
                }
                if (projects.isEmpty()) {
                    model.addAttribute("resultSearch", projects);
                    return "search";
                }
            }
        }

        projectList = new LinkedList<>(projects);
        if (!sphere.isEmpty()) {
            for (Project project : projectList) {
                if (projects.isEmpty()) {
                    model.addAttribute("resultSearch", projects);
                    return "search";
                } else {
                    if (!(project.getSphere().equals(sphere))) {
                        projects.remove(project);
                    }
                }
            }
        }

        model.addAttribute("resultSearch", projects);

        return "search";
    }

    @RequestMapping(value = "/projectInfo/{id}", method = RequestMethod.GET)
    public String projectInfo(@PathVariable("id") int id, Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:../login";
        }

        model.addAttribute("project", projectService.getById(id));
        model.addAttribute("user", projectService.getById(id).getUser());

        return "projectInfo";
    }

    @RequestMapping(value = "/mentorView", method = RequestMethod.GET)
    public String searchMentor(Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }


        List<User> mentors = new LinkedList<>();
        for (User user : userService.getAll()) {
            if (user.getType().equals("Mentor")) {
                mentors.add(user);
            }
        }
        model.addAttribute("allUsers", mentors);

        return "mentorAndInvestorView";
    }

    @RequestMapping(value = "/investorView", method = RequestMethod.GET)
    public String searchInvestor(Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:login";
        }

        List<User> investors = new LinkedList<>();
        for (User user : userService.getAll()) {
            if (user.getType().equals("Investor")) {
                investors.add(user);
            }
        }

        model.addAttribute("allUsers", investors);

        return "mentorAndInvestorView";
    }

    @RequestMapping(value = "/userInfo/{id}", method = RequestMethod.GET)
    public String userInfo(@PathVariable("id") int id, Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:../login";
        }

        model.addAttribute("user", userService.getById(id));
        model.addAttribute("projectList", userService.getById(id).getProjects());

        return "userInfo";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(Model model) {
        return "/editUserPage";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user) {

        userSession.setEmail(user.getEmail());
        userSession.setFirstname(user.getFirstname());
        userSession.setLastname(user.getLastname());
        userSession.setAbout(user.getAbout());

        userService.update(userSession);
        return "homeUser";
    }


    //================================

    @RequestMapping(value = "/addToFavorites/{id}", method = RequestMethod.GET)
    public String addToFavorites(@PathVariable("id") int id, Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:../login";
        }

        Set<Project> newFav = userSession.getFavorites();
        Project p = projectService.getById(id);
        if (!newFav.contains(p)) {
            newFav.add(p);
        }
        userSession.setFavorites(newFav);
        userService.update(userSession);

        model.addAttribute("fav", newFav);
        return "/homeUser";
    }

    @RequestMapping(value = "/removeFromFavorites/{id}", method = RequestMethod.GET)
    public String removeFromFavorites(@PathVariable("id") int id, Model model) {
        if ((userSession == null) || (userSession.getId() < 0)) {
            return "redirect:../login";
        }

        Set<Project> newFav = userSession.getFavorites();
        Project p = projectService.getById(id);
        if (newFav.contains(p)) {
            newFav.remove(p);
        }

        userSession.setFavorites(newFav);
        userService.update(userSession);

        model.addAttribute("fav", newFav);
        return "/homeUser";
    }

//================================


}