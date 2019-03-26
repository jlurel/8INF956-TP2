package web.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Guichet;

@Controller
public class IndexController {
    private Guichet guichet;

    public IndexController() {
        ApplicationContext applicationContext =
                new FileSystemXmlApplicationContext("classpath:web/guichet.xml");
        guichet = (Guichet) applicationContext.getBean("guichet");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index", "command", guichet);
        view.addObject("nom", guichet.getNom());
        view.addObject("numero", guichet.getNumero());
        view.addObject("telephone", guichet.getNumeroTel());
        view.addObject("service", guichet.getService());
        view.addObject("solde", guichet.getSolde());
        view.addObject("message", "");
        return view;
    }

    @RequestMapping(value = "/operation", method = RequestMethod.POST)
    public ModelAndView effectuerOperation(@ModelAttribute Guichet leGuichet,
                                     @RequestParam(value = "action") String action) {
        ModelAndView view = new ModelAndView("index", "command", guichet);
        switch (action) {
            case "depot" :
                guichet.deposer(leGuichet.getMontant());
                view.addObject("nom", guichet.getNom());
                view.addObject("numero", guichet.getNumero());
                view.addObject("telephone", guichet.getNumeroTel());
                view.addObject("service", guichet.getService());
                view.addObject("solde", guichet.getSolde());
                view.addObject("message", "");
                break;
            case "retrait" :
                view.addObject("message", guichet.retirer(leGuichet.getMontant()));
                view.addObject("nom", guichet.getNom());
                view.addObject("numero", guichet.getNumero());
                view.addObject("telephone", guichet.getNumeroTel());
                view.addObject("service", guichet.getService());
                view.addObject("solde", guichet.getSolde());
                break;
            default:
                break;
        }
        return view;
    }
}
