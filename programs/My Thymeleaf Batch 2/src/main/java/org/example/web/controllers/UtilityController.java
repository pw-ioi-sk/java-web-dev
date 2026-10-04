package org.example.web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@WebServlet("/utility")
public class UtilityController extends HttpServlet {

    private TemplateEngine templateEngine;

    @Override
    public void init() throws ServletException {
        templateEngine = ThymeleafConfig.createTemplateEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        JakartaServletWebApplication application =
                JakartaServletWebApplication.buildApplication(getServletContext());

        IWebExchange exchange = application.buildExchange(req, res);

        WebContext context = new WebContext(exchange, res.getLocale());

        context.setVariable("message", "Hello From Utility");

        String name = "swap";
        String[] names = {"swap", "sWap", "swAp", "SWap", "sWAp"};

        context.setVariable("name", name);
        context.setVariable("names", Arrays.toString(names));

        List<String> listNames = Arrays.asList(names);

        context.setVariable("listnames", listNames);

        Integer num = 44245468;
        Double salary = 70000000.4545;

        context.setVariable("num", num);
        context.setVariable("salary", salary);

        context.setVariable("currentTime", LocalTime.now());
        context.setVariable("currentDate", LocalDate.now());
        context.setVariable("currentDateTime", LocalDateTime.now());

        templateEngine.process("utility", context, res.getWriter());
    }
}
