package org.example.web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.config.ThymeleafConfig;
import org.example.entities.User;

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
    public void init() throws ServletException {
        templateEngine = ThymeleafConfig.createTemplateEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(getServletContext());
        IWebExchange exchange = application.buildExchange(req, res);
        WebContext context = new WebContext(exchange, req.getLocale());

        User user = new User(1, "swap", "noida", 1234567890L);

        context.setVariable("msg", user);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "swap", "noida", 1234567890L));
        users.add(new User(2, "Kunal", "noida", 987654321L));
        users.add(new User(3, "Karan", "UP", 1122334455L));

        context.setVariable("users", users);

        templateEngine.process("index" , context, res.getWriter());
    }
}