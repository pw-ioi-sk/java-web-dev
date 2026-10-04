package org.example.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.modal.User;
import org.example.modal.repository.UserRepository;
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
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        templateEngine = ThymeleafConfig.createTemplateEngine(getServletContext());
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(getServletContext());
        IWebExchange exchange = application.buildExchange(req, res);
        WebContext context = new WebContext(exchange, res.getLocale());
        context.setVariable("message", "Hello From Thymeleaf");
        context.setVariable("users", userRepository.getUsers());
        context.setVariable("user", userRepository.getFirstUser());
        context.setVariable("userid", userRepository.getUsersById(1));
        templateEngine.process("home", context, res.getWriter());
    }
}
