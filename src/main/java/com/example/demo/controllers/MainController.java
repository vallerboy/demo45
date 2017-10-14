package com.example.demo.controllers;

import com.example.demo.models.forms.CreditForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @GetMapping("/")
    public String bankTemplate(Model model) {
        model.addAttribute("creditForm", new CreditForm());
        return "bankTemplate";
    }

//    @PostMapping("/")
//    public String bankTemplate(@RequestParam("salary") int salary,
//                               @RequestParam("costs") int costs,
//                               @RequestParam("credit") int credit,
//                               @RequestParam("period") int period,
//                               Model model){
//        model.addAttribute("info", checkCredit(salary, costs, credit, period));
//        return "bankTemplate";
//    }

    @PostMapping("/")
    public String bankTemaplate(@ModelAttribute CreditForm creditForm, Model model){
                model.addAttribute("info", checkCredit(
                        creditForm.getSalary(),
                        creditForm.getCosts(),
                        creditForm.getCredit(),
                        creditForm.getPeriod()));

        return "bankTemplate";
    }


    private String checkCredit(int salary, int costs, int credit, int period) {
        return (salary - costs) * 0.30 > credit / period ? "Dostajesz kredyt" : "Nie masz kredytu!";
    }
}
