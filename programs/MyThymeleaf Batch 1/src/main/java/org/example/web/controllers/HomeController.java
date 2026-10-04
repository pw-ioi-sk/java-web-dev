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
import java.util.ArrayList;
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

        IWebExchange exchange = application.buildExchange(req, res);

        WebContext context = new WebContext(exchange, res.getLocale());
        context.setVariable("message", "Hello World!");

        User user = new User(1, "swap", "noida", 1234567890L);

        context.setVariable("user", user);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "swap", "Noida", 1234567890L));
        users.add(new User(2, "Kunal", "Noida", 1122334455L));
        users.add(new User(3, "Rahul", "Delhi", 2244660088L));
        users.add(new User(4, "Ash", "Tokyo", 1133557799L));
        users.add(new User(5, "Bawa", "Pune", 1133660099L));

        context.setVariable("users", users);

        templateEngine.process("index", context, res.getWriter());
    }
}
