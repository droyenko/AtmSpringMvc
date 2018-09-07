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
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class CardController {

    private static Logger logger = Logger.getLogger(CardController.class.getName());

    @Autowired
    public CardService cardService;

    @Autowired
    public OperationService operationService;

    @Autowired
    public AuthServiceImpl authService;

    @GetMapping("/")
    public String index() {
        logger.error("index controller");
        return "checkCardPage";
    }

    @GetMapping("/hello")
    public String hello() {
        logger.error("/hello controller");
        return "hello";
    }

    @GetMapping("/cards")
    public String getAllCards(Model model) {
        logger.error("/cards controller");
        model.addAttribute("cards", cardService.findAll());
        return "cardsList";
    }

    @GetMapping("/card/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        logger.error("/cards/id controller");
        model.addAttribute("card", cardService.getById(id));
        return "showCard";
    }

    @GetMapping("/addCard")
    public String createCardPage() {
        logger.error("GET:/addCard controller");
        return "createCard";
    }

    @PostMapping("/addCard")
    public String addCard(@ModelAttribute("card") Card card) {
        logger.error("POST:/addCard controller");
        cardService.save(card);
        return "redirect:/cards";
    }

    @GetMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable("id") int id) {
        logger.error("/deleteCard/id controller");
        cardService.delete(id);
        return "redirect:/cards";
    }

    @GetMapping("/updateCard/{id}")
    public String updateCardPage(@PathVariable("id") int id, Model model) {
        logger.error("/updateCard/id controller");
        model.addAttribute("card", cardService.getById(id));
        return "editCard";
    }

    @PostMapping("/updateCard")
    public String updateCard(@ModelAttribute("card") Card card) {
        logger.error("POST:/updateCard controller");
        cardService.update(card);
        return "redirect:/card/" + card.getId();
    }

    @GetMapping("/checkCardPage")
    public String checkCardPage() {
        return "checkCardPage";
    }

    @PostMapping("/checkCard")
    public String checkCard(@ModelAttribute("card") Card card, Model model, HttpServletResponse response) {
        String pageToShow;
        String message = cardService.isBlocked(card.getNumber());
        if (message !=null) {
            model.addAttribute("message", message);
            pageToShow = "cardNumberError";
        } else {
            authService.setAuthToResponse(response);
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
        String message = cardService.checkPin(Integer.parseInt(card.getPin()));
        String authKey = authService.getAuthFromRequest(request);
        String cardNumber = cardService.getLocalCardNumber(authKey);

        if (message != null) {
            model.addAttribute("message", message);
            pageToShow = "cardPinError";
        } else {
            model.addAttribute("cardNumber", cardNumber);
            pageToShow = "operationsPage";
        }

        return pageToShow;
    }

    @PostMapping("/checkBalance")
    public String checkBalance(@ModelAttribute("operation") Operation operation, Model model, HttpServletRequest request) {
        String pageToShow;
        String authKey = authService.getAuthFromRequest(request);
        String cardNumber = cardService.getLocalCardNumber(authKey);
        String message = cardService.processWithdrawal(operation.getAmount(), cardNumber);


        if (message != null) {
            model.addAttribute("message", message);
            pageToShow = "withdrawalError";
        } else {
            model.addAttribute("card", cardService.getCardByNumber(cardNumber));
            model.addAttribute("operation", operationService.getLastWithdrawalOperation(cardNumber));
            pageToShow = "withdrawalReport";
        }

        return pageToShow;
    }
}
