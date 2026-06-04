package ru.practicum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
    package org.springframework.web.servlet.config.annotation;

    import java.lang.annotation.Documented, ElementType, Retention, RetentionPolicy, Target;

    import org.springframework.context.annotation.Import;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Documented
    @Import(DelegatingWebMvcConfiguration.class)
    public @interface EnableWebMvc {
    }
*/

@Configuration // помечает класс как java-config для контекста приложения
@EnableWebMvc  // призывает импортировать дополнительную конфигурацию для веб-приложений
public class WebConfig {
}
