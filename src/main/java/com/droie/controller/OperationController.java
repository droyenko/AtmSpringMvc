package com.droie.controller;

import com.droie.entity.Operation;
import com.droie.service.OperationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class OperationController {

    private static Logger logger = Logger.getLogger(OperationController.class.getName());

    @Autowired
    public OperationService operationService;

    @GetMapping("/operations")
    public String getAllOperations(Model model) {
        logger.error("/operations controller");
        model.addAttribute("operations", operationService.findAll());
        return "operationsList";
    }

    @GetMapping("/operation/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        logger.error("/operations/id controller");
        model.addAttribute("operation", operationService.getById(id));
        return "showOperation";
    }

    @GetMapping("/addOperation")
    public String createOperationPage() {
        logger.error("GET:/addOperation controller");
        return "createOperation";
    }

    @PostMapping("/addOperation")
    public String addOperation(@ModelAttribute("operation") Operation operation) {
        logger.error("POST:/addOperation controller");
        operationService.save(operation);
        return "redirect:/operations";
    }

    @GetMapping("/deleteOperation/{id}")
    public String deleteOperation(@PathVariable("id") int id) {
        logger.error("/deleteOperation/id controller");
        operationService.delete(id);
        return "redirect:/operations";
    }

    @GetMapping("/updateOperation/{id}")
    public String updateOperationPage(@PathVariable("id") int id, Model model) {
        logger.error("/updateOperation/id controller");
        model.addAttribute("operation", operationService.getById(id));
        return "editOperation";
    }

    @PostMapping("/updateOperation")
    public String updateOperation(@ModelAttribute("operation") Operation operation) {
        logger.error("POST:/updateOperation controller");
        operationService.update(operation);
        return "redirect:/operation/" + operation.getId();
    }
}