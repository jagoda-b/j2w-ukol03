package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> vizitky = new ArrayList<>();

    public VizitkaController() {
        vizitky.add(new Vizitka("John Doe", "Company A", "Herálecká Ⅰ 1578/10", "Prague, 140 00", "john.doe@companya.com", "123456789", "www.companya.com"));
        vizitky.add(new Vizitka("Jane Doe", "Company B", "Na Schodech 50/2", "Prague, 140 00", "test@test.com", "987654321", "www.companyb.com"));
        vizitky.add(new Vizitka("John Smith", "Company C", "Toužimská 909", " Prague, 199 00", "smith@companyc.com", "111222333", "www.companyc.com"));
        vizitky.add(new Vizitka("Jane Smith", "Company D", "Holečkova 3149/25a", "Prague, 150 00", "smith@companyd.com", "444555666", "www.companyd.com"));
        vizitky.add(new Vizitka("John Johnson", "Company E", "U Sluncové 612/21", "Prague, 186 00", "johnson@companye.com", "777888999", "www.companye.com"));
        Vizitka vizitka1 = new Vizitka();
        vizitka1.setJmeno("Jane Johnson");
        vizitka1.setFirma("Company F");
        vizitka1.setUlice("Vratislavská 397/4");
        vizitka1.setObecPsc("Prague, 181 00");

        vizitky.add(vizitka1);

        Vizitka vizitka2 = new Vizitka();
        vizitka2.setJmeno("John Brown");
        vizitka2.setFirma("Company G");
        vizitka2.setUlice("Roztylské sady 1089/16");
        vizitka2.setObecPsc("Prague, 141 00");

        vizitky.add(vizitka2);
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("vizitky", vizitky);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("vizitka", vizitky.get(id));
        return modelAndView;
    }
}
