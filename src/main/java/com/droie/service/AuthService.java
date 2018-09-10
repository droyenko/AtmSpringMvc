package com.droie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    String getLocalCardNumber(HttpServletRequest request);

    String setLocalCardNumber(String number);

    void setAuthenticated(HttpServletRequest request);

    Boolean isAuthenticated(HttpServletRequest request);

    String generate();

    String getAuthFromRequest(HttpServletRequest request);

    void setAuthToResponse(String authKey, HttpServletResponse response);

    void clearCookies(HttpServletResponse response);
}
