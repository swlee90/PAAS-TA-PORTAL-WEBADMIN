package org.openpaas.paasta.portal.web.admin.config.security;

import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessPortal implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        StringBuffer url = request.getRequestURL(); //index?logout
        String index = request.getRequestURI();//console-admin.paas.smes-tipa.go.kr/index?logout
        StringBuffer result = url.delete(url.indexOf(index), url.length());
        result = result.replace(0,7, "https://");
        response.sendRedirect(result.toString()+"/index?logout");
    }
}
