package ru.edmitryv.birthday_scheduler.controllers;

import org.springframework.ui.Model;
import ru.edmitryv.birthday_scheduler.models.Person;
import ru.edmitryv.birthday_scheduler.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonController {
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    PersonService personService;

    @GetMapping("/")
    public String getMain(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        model.addAttribute("new_person", new Person());
        return "index";
    }

    @PostMapping("/person/add")
    public String savePerson(@ModelAttribute("new_person") Person person) {
        personService.savePerson(person);
        return "redirect:/";
    }
}
