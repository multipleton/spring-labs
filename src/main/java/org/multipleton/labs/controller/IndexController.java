package org.multipleton.labs.controller;

import org.multipleton.labs.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("book", new BookDto());
        return "admin";
    }

    @RequestMapping("/guest")
    public String guest() {
        return "guest";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
