package com.example.demo.controllers;

import com.example.demo.models.CreditModel;
import com.example.demo.models.forms.CreditForm;
import com.example.demo.models.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;

@Controller
public class MainController {

    @Autowired
    CreditRepository creditRepository;

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
    public String bankTemaplate(@ModelAttribute("creditForm") @Valid CreditForm creditForm, BindingResult result, Model model){

        if(result.hasErrors()){
            return "bankTemplate";
        }

        model.addAttribute("info", checkCredit(
                        creditForm.getSalary(),
                        creditForm.getCosts(),
                        creditForm.getCredit(),
                        Integer.valueOf(creditForm.getPeriod())));

        creditRepository.save(new CreditModel(creditForm));
        return "bankTemplate";
    }


    private String checkCredit(int salary, int costs, int credit, int period) {
        return (salary - costs) * 0.30 > credit / period ? "Dostajesz kredyt" : "Nie masz kredytu!";
    }


}
