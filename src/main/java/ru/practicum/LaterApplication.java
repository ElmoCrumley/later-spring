package ru.practicum;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.LifecycleException;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LaterApplication {
    private static final int PORT = 8080;

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        // connector — это компонент, который отвечает за «сеть»
        tomcat.getConnector().setPort(PORT);

        // то самое «приложение» или «контекст» с пустым путём
        Context tomcatContext = tomcat.addContext("", null);

        // создаём контекст
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setServletContext(tomcatContext.getServletContext());
        applicationContext.scan("ru.practicum"); // искать бины
        applicationContext.refresh(); // .refresh загружает Spring-контекст

        // добавляем диспетчер запросов
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        Wrapper dispatcherWrapper = Tomcat.addServlet(tomcatContext, "dispatcher", dispatcherServlet);
        dispatcherWrapper.addMapping("/"); // отвечает за то, что сервлет будет обрабатывать все пути, начиная с корневого
        dispatcherWrapper.setLoadOnStartup(1); // показывает, что сервлет будет инициализирован при запуске контейнера, а не при первом запросе

        tomcat.start();
    }
}