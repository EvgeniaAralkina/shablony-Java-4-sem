package com.example.controllers;


import com.example.Manufacture;
import com.example.dao.EmailService;
import com.example.dao.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    private EmailService emailService;

    private final ManufactureService manufactureService;

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("manufacture", manufactureService.index());
        return "manufacture_index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        //System.out.println(name);
        model.addAttribute("manufacture", manufactureService.show(id));
        return "manufacture_show";
    }

    @GetMapping("/new")
    public String newManufacture(@ModelAttribute("manufacture") Manufacture manufacture) {
        return "manufacture_new";
    }

    @PostMapping()
    public String create(@ModelAttribute("manufacture") Manufacture manufacture) {
        manufactureService.save(manufacture);
        emailService.sendEmail("new manufacture has been added:\n\tname: "+
                manufacture.getName()+"\n\taddress: "+ manufacture.getAddress());
        return "redirect:/manufacture";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println("deleteMapping");
        manufactureService.delete(id);
        return "redirect:/manufacture";
    }

    //pr17
    @GetMapping("/filteredByName")
    public String getManufactureFilteredByName(Model model){
        model.addAttribute("manufacture", manufactureService.getManufactureFilteredByName());
        return "manufacture_index";
    }

    @GetMapping("/filteredByAddress")
    public String getManufactureFilteredByAddress(Model model){
        model.addAttribute("manufacture", manufactureService.getManufactureFilteredByAddress());
        return "manufacture_index";
    }
}
