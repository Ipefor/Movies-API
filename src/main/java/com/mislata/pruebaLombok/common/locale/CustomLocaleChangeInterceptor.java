package com.mislata.pruebaLombok.common.locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {


    private final String defaultlanguage;
    public CustomLocaleChangeInterceptor(String defaultlanguage) {
        this.defaultlanguage = defaultlanguage;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        String lang = request.getHeader("Accept-Language"); // Obtiene el valor de la cabecera
        Locale locale = lang != null ? Locale.forLanguageTag(lang) : Locale.of("es");

        LanguageUtils.setCurrentLocale(locale); // Establece el idioma actual

        return super.preHandle(request, response, handler); // Llama al método preHandle de la clase padre
    }
}
