package org.openpaas.paasta.portal.web.admin.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class CustomLoginSuccessPortal implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        StringBuffer url = request.getRequestURL();
        String index = request.getRequestURI();
        StringBuffer result = url.delete(url.indexOf(index), url.length());
        result = result.replace(0,7, "https://");
        response.sendRedirect(result.toString()+"/dashboard");
    }
}
