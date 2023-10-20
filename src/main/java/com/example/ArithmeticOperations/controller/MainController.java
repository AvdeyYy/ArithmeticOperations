package com.example.ArithmeticOperations.controller;


import com.example.ArithmeticOperations.service.impl.OperationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    OperationsServiceImpl operationsService;

    @Autowired
    public MainController(OperationsServiceImpl operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @PostMapping("/sum")
    public String sum(String line, Model model) {
        model.addAttribute("MySum", Boolean.TRUE);
        model.addAttribute("result", operationsService.sum(line));
        return "main";
    }

    @PostMapping("/multiply")
    public String multiply(String line, Model model) {
        model.addAttribute("MyMultiply", Boolean.TRUE);
        model.addAttribute("result", operationsService.multiply(line));
        return "main";
    }

    @PostMapping("/multiplyAndSum")
    public String multiAndSum(String line, Model model) {
        model.addAttribute("MyMultiplyAndSum", Boolean.TRUE);
        model.addAttribute("result", operationsService.multiplyAndSum(line));
        return "main";
    }

    @PostMapping("/sumAndDivide")
    public String sumAndDivision(String line, Model model) {
        model.addAttribute("MySumAndDivide", Boolean.TRUE);
        model.addAttribute("result", operationsService.sumAndDivide(line));
        return "main";
    }

}
