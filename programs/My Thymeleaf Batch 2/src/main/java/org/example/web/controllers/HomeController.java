package org.example.web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.modal.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/")
public class HomeController extends HttpServlet {

    private TemplateEngine templateEngine;

    @Override
    public void init() {
        templateEngine =
                ThymeleafConfig.createTemplateEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        JakartaServletWebApplication application =
                JakartaServletWebApplication.buildApplication(getServletContext());

        IWebExchange exchange = application.buildExchange(req ,res);

        WebContext context = new WebContext(exchange, res.getLocale());

        // Storing data to the WebContext to be used in variable expression
        context.setVariable("message", "Hello From Thymeleaf");

        User user =
                new User(1 ,"swap", "noida", 1234567890L);

        context.setVariable("user", user);

        List<User> users = new ArrayList<>();
        users.add(new User(1 ,"swap", "noida", 1234567890L));
        users.add(new User( 2,"Kunal", "noida", 9876543211L));
        users.add(new User( 3,"Rahul", "BLR", 1122334455L));

        context.setVariable("users", users);
        context.setVariable("age", 25);
        context.setVariable("salary", 1245678.5235);

        LocalDate today = LocalDate.now();

        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalTime currentTime = LocalTime.now();

        context.setVariable("today", today);
        context.setVariable("currentDateTime", currentDateTime);
        context.setVariable("currentTime", currentTime);

        String[] names = {"hello", "hLleo", "HlleO", "HLLeo", "hellO"};
        context.setVariable("names", Arrays.toString(names));
        templateEngine.process("index", context, res.getWriter());
    }
}
