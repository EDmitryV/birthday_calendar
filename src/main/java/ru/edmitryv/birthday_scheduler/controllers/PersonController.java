package ru.edmitryv.birthday_scheduler.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import ru.edmitryv.birthday_scheduler.models.Person;
import ru.edmitryv.birthday_scheduler.models.User;
import ru.edmitryv.birthday_scheduler.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.edmitryv.birthday_scheduler.services.UserService;

import java.util.List;


@Controller
public class PersonController {
    @Autowired
    public PersonController(PersonService personService, UserService userService) {
        this.personService = personService;
        this.userService = userService;
    }

    PersonService personService;

    UserService userService;

    @GetMapping("/")
    public String getMain(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user_name", user.getUsername());
        model.addAttribute("persons", user.getPersons());
        model.addAttribute("new_person", new Person());
        return "index";
    }

    @PostMapping("/person/add")
    public String savePerson(@ModelAttribute("new_person") Person person, @AuthenticationPrincipal User user) {
        person.setUser(user);
        personService.savePerson(person);
        user.getPersons().add(person);
        userService.saveUser(user);
        return "redirect:/main";
    }
}
