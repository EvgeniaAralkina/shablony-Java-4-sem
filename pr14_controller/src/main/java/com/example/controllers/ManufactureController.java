package com.example.controllers;

import com.example.Manufacture;
import com.example.dao.ManufactureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    private final ManufactureDAO manufactureDAO;

    @Autowired
    public ManufactureController(ManufactureDAO manufactureDAO) {
        this.manufactureDAO = manufactureDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("manufacture", manufactureDAO.index());
        return "manufacture_index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        model.addAttribute("manufacture", manufactureDAO.show(id));
        return "manufacture_show";
    }

    @GetMapping("/new")
    public String newManufacture(@ModelAttribute("manufacture") Manufacture manufacture) {
        return "manufacture_new";
    }

    @PostMapping()
    public String create(@ModelAttribute("manufacture") Manufacture manufacture) {
        manufactureDAO.save(manufacture);
        return "redirect:/manufacture";
    }

   @DeleteMapping("/{id}")
   public String delete(@PathVariable("id") int id) {
       System.out.println("deleteMapping");
       manufactureDAO.delete(id);
       return "redirect:/manufacture";
   }
}


