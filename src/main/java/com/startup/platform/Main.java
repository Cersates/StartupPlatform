package com.startup.platform;

import com.startup.platform.dao.UserDao;
import com.startup.platform.dao.impl.UserDaoImpl;
import com.startup.platform.model.Project;
import com.startup.platform.model.User;
import com.startup.platform.service.UserService;
import com.startup.platform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        testApp();
        BigInteger i1 = new BigInteger("2");
        BigInteger i2 = new BigInteger("1");
        System.out.println(i1.compareTo(i2));

//        1==1=0
//        1==2=-1
//        2==1=
    }

    private static void testApp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-context.xml");
        UserService service = (UserService) context.getBean("userService");
        testHibernate1();
        System.exit(0);

    }


    private static void testHibernate1() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = new User();
        user.setFirstname("asd");
        user.setLastname("zxc");
        user.setPassword("123");
        Set<Project> projects = new HashSet<Project>();
        Project project1 = new Project();
        Project project2 = new Project();

        project1.setTitle("title1");
        project1.setDescription("description1");
        project1.setUser(user);

        project2.setTitle("title2");
        project2.setDescription("description2");
        project2.setUser(user);

        projects.add(project1);
        projects.add(project2);
        user.setProjects(projects);

        Set<Project> favor = new HashSet<Project>();
        favor.add(project1);
        user.setFavorites(favor);


        session.save(user);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }

    private static void testHibernate2() {

        UserDao userDao = new UserDaoImpl();


        User user = new User();
        user.setFirstname("asd");
        user.setLastname("zxc");
        user.setPassword("123");
        Set<Project> projects = new HashSet<Project>();
        Project project1 = new Project();
        Project project2 = new Project();

        project1.setTitle("title1");
        project1.setDescription("description1");
        project1.setUser(user);

        project2.setTitle("title2");
        project2.setDescription("description2");
        project2.setUser(user);

        projects.add(project1);
        projects.add(project2);
        user.setProjects(projects);

        userDao.add(user);

    }

    private static void testHibernate3() {
        UserDao userDao = new UserDaoImpl();

        for (User user : userDao.getAll()) {
            System.out.println(user);
            for (Project project : user.getProjects()) {
                System.out.println(project);
            }
        }

        System.exit(0);
    }

    private static void testSpring() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-context.xml");
//        PaymentService service = (PaymentService) context.getBean("paymentService");

//        service.addPayment(new Payment(new BigDecimal("1000"), 1, 1));
//        for (Payment payment : service.getPayments()) {
//            System.out.println(payment.toString());
//        }
        System.out.println("ok");

    }

}
