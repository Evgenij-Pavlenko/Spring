package org.de.controllers;

import org.de.dao.PersonDao;
import org.de.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    //получаем всех людей из DAO
    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    //получаем одного человека по id из DAO
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }
    @PostMapping("")
    public String create(@ModelAttribute("person") Person person){
        personDao.save(person);
        return "redirect:/people";
    }

}
