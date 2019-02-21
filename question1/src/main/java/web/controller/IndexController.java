package web.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Guichet;

@Controller
public class IndexController {
    private Guichet guichet;

    public IndexController() {
        ApplicationContext applicationContext =
                new FileSystemXmlApplicationContext("classpath:web/client-beans.xml");
        guichet = (Guichet) applicationContext.getBean("guichet");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelMap m) {
        ModelAndView view = new ModelAndView("index", "command", guichet);
        view.addObject("nom", guichet.getNom());
        view.addObject("numero", guichet.getNumero());
        view.addObject("telephone", guichet.getNumeroTel());
        view.addObject("service", guichet.getService());
        view.addObject("solde", guichet.getSolde());
        view.addObject("message", "");
        return view;
    }

    @RequestMapping(value = "/depot", method = RequestMethod.POST)
    public String depot(Guichet leGuichet, ModelMap modelMap) {
        guichet.deposer(leGuichet.getMontantDepot());
        modelMap.addAttribute("nom", guichet.getNom());
        modelMap.addAttribute("numero", guichet.getNumero());
        modelMap.addAttribute("telephone", guichet.getNumeroTel());
        modelMap.addAttribute("service", guichet.getService());
        modelMap.addAttribute("solde", guichet.getSolde());
        modelMap.addAttribute("message", "");
        return "redirect:/";
    }

    @RequestMapping(value = "/retrait", method = RequestMethod.POST)
    public String retrait(Guichet leGuichet, ModelMap modelMap) {
        modelMap.addAttribute("message", guichet.retirer(leGuichet.getMontantRetrait()));
        modelMap.addAttribute("nom", guichet.getNom());
        modelMap.addAttribute("numero", guichet.getNumero());
        modelMap.addAttribute("telephone", guichet.getNumeroTel());
        modelMap.addAttribute("service", guichet.getService());
        modelMap.addAttribute("solde", guichet.getSolde());
        return "redirect:/";
    }
}
