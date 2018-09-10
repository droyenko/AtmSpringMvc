package com.droie.controller;

import com.droie.entity.Card;
import com.droie.entity.Operation;
import com.droie.service.CardService;
import com.droie.service.OperationService;
import com.droie.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class CardController {

    @Autowired
    public CardService cardService;

    @Autowired
    public OperationService operationService;

    @Autowired
    public AuthServiceImpl authService;

    @GetMapping("/")
    public String index(HttpServletResponse response) {
        authService.clearCookies(response);
        return "checkCardPage";
    }

    @GetMapping("/checkCardPage")
    public String checkCardPage(HttpServletResponse response) {
        authService.clearCookies(response);
        return "checkCardPage";
    }

    @PostMapping("/checkCard")
    public String checkCard(@ModelAttribute("card") Card card, Model model, HttpServletResponse response, HttpServletRequest request) {
        String pageToShow;
        String message = cardService.isBlocked(card.getNumber().replace("-", ""));
        if (message !=null) {
            model.addAttribute("message", message);
            pageToShow = "errorPage";
        } else {
            authService.setAuthToResponse(response, request);
            pageToShow = "checkPinPage";
        }

        return pageToShow;
    }

    @GetMapping("/checkPinPage")
    public String checkPinPage() {
        return "checkPinPage";
    }

    @PostMapping("/checkPin")
    public String checkPin(@ModelAttribute("card") Card card, Model model, HttpServletRequest request) {
        String pageToShow;
        String cardNumber = authService.getLocalCardNumber(request);
        String message = cardService.checkPin(Integer.parseInt(card.getPin()), cardNumber, request);

        if (message != null) {
            model.addAttribute("message", message);
            pageToShow = "errorPage";
        } else {
            model.addAttribute("cardNumber", cardNumber);
            pageToShow = "operationsPage";
        }

        return pageToShow;
    }

    @PostMapping("/checkBalance")
    public String checkBalance(@ModelAttribute("operation") Operation operation, Model model, HttpServletRequest request) {
        String pageToShow;
        String cardNumber = authService.getLocalCardNumber(request);
        String message = cardService.processWithdrawal(operation.getAmount(), cardNumber);


        if (message != null) {
            model.addAttribute("message", message);
            pageToShow = "errorPage";
        } else {
            model.addAttribute("card", cardService.getCardByNumber(cardNumber));
            model.addAttribute("operation", operationService.getLastWithdrawalOperation(cardNumber));
            pageToShow = "withdrawalReport";
        }

        return pageToShow;
    }
}
