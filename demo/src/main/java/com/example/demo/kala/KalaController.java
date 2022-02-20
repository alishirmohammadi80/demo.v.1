package com.example.demo.kala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class KalaController {

@Autowired

KalaService kalaService;


    public KalaController(KalaService kalaServise) {
        this.kalaService = kalaServise;
    }

    @GetMapping("/kala")
    public String listkala(Model model){
        model.addAttribute("kala",kalaService.getAllKala());
        return "kala";
    }
    @GetMapping("/kala/new")
    public String createKalaForm(Model model){
        Kala kala=new Kala();
        model.addAttribute("kala",kala);
        return "import_kala";

    }
    @PostMapping("/kala")
    public String saveStudent(@ModelAttribute ("kala") Kala kala){

        kalaService.saveKala(kala);

        return "redirect:/kala";
    }
    @GetMapping("/kala/edit/{id}")
    public String editKalaForm(@PathVariable Long id ,Model model){
        model.addAttribute("kala", kalaService.getKalaById(id));
        return "edite_kala";
    }
    @PostMapping("/kala/{id}")
    public String updatekala(@PathVariable Long id,@ModelAttribute("kala")Kala kala,Model model){
        Kala existingKala=kalaService.getKalaById(id);
        existingKala.setId(id);
        existingKala.setNameKala(kala.getNameKala());
        existingKala.setTadadKala(kala.getTadadKala());


       kalaService.updateKala(existingKala);

        return "redirect:/kala";
    }
    @GetMapping("/kala/{id}")
    public String deleteKala(@PathVariable long id){
      kalaService.deleteKalaById(id);
        return "redirect:/kala";
    }
}
