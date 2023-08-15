package com.example.demo.Package;

import com.example.demo.JavaClasses.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatabaseController {
    @Autowired
    HomeController home;

    @RequestMapping("/seeLawyerList")
    public String getLawyerList(Model model){
        model.addAttribute("database",home.database);
        return "LawyerList";
    }
    @PostMapping("/processExtraAction")
    public ModelAndView processExtraAction(@RequestParam("lawyer") Lawyer lawyer) {

    // Here you can perform any processing with the 'lawyer' object
        // For example: log its properties, update the database, etc.

        // Create a ModelAndView instance and set view name and model attributes
        System.out.println(lawyer.getName());
        System.out.println(lawyer);
        ModelAndView modelAndView = new ModelAndView("DemoLawyerProfile");
        modelAndView.addObject(lawyer);
        return modelAndView;
    }
}
