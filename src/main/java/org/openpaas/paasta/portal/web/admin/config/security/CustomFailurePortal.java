package org.openpaas.paasta.portal.web.admin.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFailurePortal implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        StringBuffer url = request.getRequestURL();
        String index = request.getRequestURI();
        StringBuffer result = url.delete(url.indexOf(index), url.length());
        result = result.replace(0,7, "https://");
        response.sendRedirect(result.toString()+"/index?error");
    }
}
