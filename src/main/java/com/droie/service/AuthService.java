package com.droie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    String getLocalCardNumber(HttpServletRequest request);

    String getAuthKey();

    void setAuthKey(String authKey);

    void setLocalCardNumber(String number);

    void setAuthenticated(HttpServletRequest request);

    Boolean isAuthenticated(HttpServletRequest request);

    String generate();

    String getAuthFromRequest(HttpServletRequest request);

    void setAuthToResponse(HttpServletResponse response, HttpServletRequest request);

    void clearCookies(HttpServletResponse response);
}
