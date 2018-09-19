package com.droie.service.impl;

import com.droie.service.AuthService;
import com.sun.istack.internal.Nullable;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private String headerName = "secretKey";

    private Map<String, AuthData> localCardNumber = new HashMap<>();

    private class AuthData {
        private String cardNumber;
        private Boolean authenticated;

        AuthData(String cardNumber, Boolean authenticated) {
            this.cardNumber = cardNumber;
            this.authenticated = authenticated;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public Boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(Boolean authenticated) {
            this.authenticated = authenticated;
        }
    }

    @Override
    public String getLocalCardNumber(HttpServletRequest request) {
        return localCardNumber.get(getAuthFromRequest(request)).getCardNumber();
    }

    @Override
    public String setLocalCardNumber(String number) {
        String authKey = generate();
        localCardNumber.put(authKey, new AuthData(number, false));
        return authKey;
    }

    @Override
    @Nullable
    public void setAuthenticated(HttpServletRequest request) {
        localCardNumber.get(getAuthFromRequest(request)).setAuthenticated(true);
    }

    @Override
    public Boolean isAuthenticated(HttpServletRequest request) {
        return localCardNumber.get(getAuthFromRequest(request)).isAuthenticated();
    }

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
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
    public void setAuthToResponse(String authKey, HttpServletResponse response) {
        Cookie cookie = new Cookie(headerName, authKey);
        response.addCookie(cookie);
    }

    @Override
    public void clearCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie(headerName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
