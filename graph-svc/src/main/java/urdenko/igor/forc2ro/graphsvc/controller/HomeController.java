package urdenko.igor.forc2ro.graphsvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Implements a controller for the project's home page.
 **/
@Controller
public class HomeController {
    @RequestMapping
    public String home(Model model) {
        return "home";
    }
}
