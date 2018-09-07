package com.droie.service.impl;

import com.droie.service.AuthService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    private ThreadLocal<String> authKey = new ThreadLocal<>();
    private String headerName = "secretKey";

    @Override
    public String getHeaderName() {
        return headerName;
    }

    @Override
    public String getAuthKey() {
        return authKey.get();
    }

    @Override
    public void setAuthKey(String authKey) {
        this.authKey.set(authKey);
    }

    @Override
    public String generate() {
        String uuid = UUID.randomUUID().toString();
        setAuthKey(uuid);
        return uuid;
    }

    @Override
    public String getAuthFromRequest(HttpServletRequest request) {
        String key = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(headerName)) {
                key = cookie.getValue();
            }
        }
        return key;
    }

    @Override
    public void setAuthToResponse(HttpServletResponse response) {
        Cookie cookie = new Cookie(headerName, getAuthKey());
        response.addCookie(cookie);
    }
}
