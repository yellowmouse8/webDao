package ru.specialist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.specialist.model.UserVM;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private UserVM userVM;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model uiModel){
        uiModel.addAttribute("user", userVM);
        return "hello/form";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String showHello(UserVM userVM, BindingResult bindingResult,
                            Model uiModel){
        this.userVM.setUserName(userVM.getUserName());
        uiModel.addAttribute("user", this.userVM);
        return "hello/form";
    }
}
