package com.example.controllers;

import com.example.Worker;
import com.example.dao.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerDAO workerDAO;

    @Autowired
    public WorkerController(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("worker", workerDAO.index());
        return "worker_index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        System.out.println("controller " + id);
        model.addAttribute("worker", workerDAO.show(id));
        return "worker_show";
    }

    @GetMapping("/new")
    public String newWorker(@ModelAttribute("worker") Worker worker) {
        return "worker_new";
    }

    @PostMapping()
    public String create(@ModelAttribute("worker") Worker worker) {
        workerDAO.save(worker);
        return "redirect:/worker";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        System.out.println("deleteMapping");
        workerDAO.delete(id);
        return "redirect:/worker";
    }

    // пр16
    @GetMapping(value = "/{id}/manufacture")
    public String getWorkerUser(@PathVariable("id")
                                                 int id, Model model){
        model.addAttribute("worker", workerDAO.getManufactureByWorker(id));
        return "worker_manufacture_16";
        //return dogService.getUserByDog(dogId);
    }
}
