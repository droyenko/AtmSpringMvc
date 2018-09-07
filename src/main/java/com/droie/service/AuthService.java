package com.droie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    String getHeaderName();

    String getAuthKey();

    void setAuthKey(String authKey);

    String generate();

    String getAuthFromRequest(HttpServletRequest request);

    void setAuthToResponse(HttpServletResponse response);
}
