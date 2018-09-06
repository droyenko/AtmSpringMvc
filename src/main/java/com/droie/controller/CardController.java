package com.droie.controller;

import com.droie.entity.Card;
import com.droie.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class CardController {

    private static Logger logger = Logger.getLogger(CardController.class.getName());

    @Autowired
    public CardService cardService;

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
    public String checkCard(@ModelAttribute("card") Card card, Model model) {
        String pageToShow;
        String message = cardService.isBlocked(card.getNumber());

        if (message !=null) {
            model.addAttribute("message", message);
            pageToShow = "cardNumberError";
        } else {
            pageToShow = "checkPinPage";
        }

        return pageToShow;
    }

    @GetMapping("/checkPinPage")
    public String checkPinPage() {
        return "checkPinPage";
    }

    @PostMapping("/checkPin")
    public String checkPin(@ModelAttribute("card") Card card, Model model) {
        String pageToShow;
        String message = cardService.checkPin(card.getPin());

        if (message != null) {
            model.addAttribute("message", message);
            pageToShow = "cardPinError";
        } else {
            model.addAttribute("cardNumber", cardService.getLocalCardNumber());
            pageToShow = "operationsPage";
        }

        return pageToShow;
    }

    @PostMapping("/checkBalance")
    public String checkBalance(@ModelAttribute("card") Card card, Model model) {
        String pageToShow;
        String message = cardService.processWithdrawal(card.getBalance());

        if (message != null) {
            model.addAttribute("message", message);
            pageToShow = "withdrawalError";
        } else {
            model.addAttribute("card", card);
            pageToShow = "withdrawalReport";
        }

        return pageToShow;
    }
}
