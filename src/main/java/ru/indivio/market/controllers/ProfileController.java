package ru.indivio.market.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.indivio.market.entites.User;
import ru.indivio.market.services.UsrService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {
    private UsrService usrService;

    @Autowired
    public void setUserServiceImpl(UsrService usrService) {
        this.usrService = usrService;
    }

    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {

        model.addAttribute("profile", usrService.findByName(principal.getName()));
        //model.addAttribute("profiles", "123");
        return "profile";
    }

}
