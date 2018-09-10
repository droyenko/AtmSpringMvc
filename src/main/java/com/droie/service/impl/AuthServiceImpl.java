package com.droie.service.impl;

import com.droie.service.AuthService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    private ThreadLocal<String> authKey = new ThreadLocal<>();
    private String headerName = "secretKey";

    private Map<String, AuthData> localCardNumber = new HashMap<>();

    private class AuthData {
        private String cardNumber;
        private Boolean authenticated;

        public AuthData(String cardNumber, Boolean authenticated) {
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
    public String getAuthKey() {
        return authKey.get();
    }

    @Override
    public void setAuthKey(String authKey) {
        this.authKey.set(authKey);
    }

    @Override
    public void setLocalCardNumber(String number) {
        localCardNumber.put(generate(), new AuthData(number, false));
    }

    @Override
    public void setAuthenticated(HttpServletRequest request) {
        localCardNumber.get(getAuthFromRequest(request)).setAuthenticated(true);
    }

    @Override
    public Boolean isAuthenticated(HttpServletRequest request) {
        return localCardNumber.get(getAuthFromRequest(request)).isAuthenticated();
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
    public void setAuthToResponse(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie(headerName, getAuthKey());
        response.addCookie(cookie);
    }

    @Override
    public void clearCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie(headerName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
