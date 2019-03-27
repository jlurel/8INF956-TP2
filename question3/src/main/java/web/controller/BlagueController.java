/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controller;

import web.model.Blague;
import web.dao.BlagueDAO;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fadou
 */

@Controller
@RequestMapping("blague")
public class BlagueController {
    @Autowired  //get the auto-generated bean called BlagueService
    private BlagueDAO blagueDAO;
    
    @GetMapping(path="/all")  //@GetMapping is a shortcut for @RequestMapping(method=GET)
    public String getAllBlagues(ModelMap m){
        List<Blague> blagues = (List<Blague>)blagueDAO.findAll();
        m.put("blagues",blagues);
        return "allBlagues";
    }
    
    @GetMapping(path="/random")
    public String getRandom(ModelMap m){
        Random rand = new Random();
        long nbBlagues = blagueDAO.count();
        int randomNb = rand.nextInt((int)nbBlagues);
        randomNb += 1;
        Optional<Blague> blague = blagueDAO.findById(randomNb);
        m.put("blague", blague.get());
        return "randomBlague";
    }
    
    @GetMapping(path="/add")
    public String add(ModelMap m){
        m.addAttribute("blague", new Blague());
        return "addBlague";
    }
    
    @PostMapping(path="/add")
    public String add(@ModelAttribute("blague") Blague blague, Model model){
        blagueDAO.save(blague);
        model.addAttribute("message", "<strong>Merci!</strong> La blague a bien été ajouté.");
        return "addBlague";
    }
}

//Reference : https://spring.io/guides/gs/accessing-data-mysql/
