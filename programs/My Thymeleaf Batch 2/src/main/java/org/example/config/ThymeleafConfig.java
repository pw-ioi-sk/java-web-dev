package org.example.config;

import jakarta.servlet.ServletContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

public class ThymeleafConfig {
    public static TemplateEngine createTemplateEngine(ServletContext context) {
        JakartaServletWebApplication application =
                JakartaServletWebApplication.buildApplication(context);

        WebApplicationTemplateResolver resolver =
                new WebApplicationTemplateResolver(application);

        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        return templateEngine;
    }
}
