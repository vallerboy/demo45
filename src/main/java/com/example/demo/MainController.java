package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    @GetMapping("/")
    public String bankTemplate() {
        return "bankTemplate";
    }

    @PostMapping("/")
    public String bankTemplate(@RequestParam("salary") int salary,
                               @RequestParam("costs") int costs,
                               @RequestParam("credit") int credit,
                               @RequestParam("period") int period,
                               Model model){
        model.addAttribute("info", checkCredit(salary, costs, credit, period));
        return "bankTemplate";
    }

    private String checkCredit(int salary, int costs, int credit, int period) {
        return (salary - costs) * 0.30 > credit / period ? "Dostajesz kredyt" : "Nie masz kredytu!";
    }
}
