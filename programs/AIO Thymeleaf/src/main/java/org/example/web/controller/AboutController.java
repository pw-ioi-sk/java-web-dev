package org.example.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.modal.repository.UserRepository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet("/about")
public class AboutController extends HttpServlet {

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
        templateEngine.process("about", context, res.getWriter());
    }
}
