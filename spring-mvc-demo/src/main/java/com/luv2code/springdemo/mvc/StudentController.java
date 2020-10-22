package com.luv2code.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{favoriteLanguage}")
    private Map<String, String> favoriteLanguageOptions;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        // create new Student object
        Student theStudent = new Student();
        // add student object to the model
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("theCountryOptions", countryOptions);
        theModel.addAttribute("theFavoriteLanguage", favoriteLanguageOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        //log the input data
        System.out.println("theStudent: " +
                theStudent.getFirstName() + " " +
                theStudent.getLastName());
        return "student-confirmation";
    }
}
