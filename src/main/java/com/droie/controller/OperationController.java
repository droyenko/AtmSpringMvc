package com.droie.controller;

import com.droie.entity.Operation;
import com.droie.service.AuthService;
import com.droie.service.CardService;
import com.droie.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class OperationController {

    @Autowired
    public OperationService operationService;

    @Autowired
    public CardService cardService;

    @Autowired
    public AuthService authService;

    @GetMapping("/operationsPage")
    public String operationsPage(Model model, HttpServletRequest request) {
        if (authService.isAuthenticated(request)) {
            model.addAttribute("cardNumber", authService.getLocalCardNumber(request));
            return "operationsPage";
        }
        return "checkCardPage";
    }

    @GetMapping("/balanceReport")
    public String balanceReport() {
        return "balanceReport";
    }

    @PostMapping("/balanceReport")
    public String saveBalanceOperation(@ModelAttribute("operation") Operation operation, Model model, HttpServletRequest request) {
        if (authService.isAuthenticated(request)) {
            operationService.save(operation);
            model.addAttribute("operation", operation);
            model.addAttribute("balance", cardService.getBalance(operation.getCardId()));
            return "balanceReport";
        }
        return "checkCardPage";
    }

    @GetMapping("/withdrawalPage")
    public String withdrawalPage(HttpServletRequest request) {
        if (authService.isAuthenticated(request)) {
            return "withdrawalPage";
        }
        return "checkCardPage";
    }
}