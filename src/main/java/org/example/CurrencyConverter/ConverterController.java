package org.example.CurrencyConverter;

import org.example.CurrencyConverter.domain.History;
import org.example.CurrencyConverter.domain.Valute;
import org.example.CurrencyConverter.repos.HistoryRepo;
import org.example.CurrencyConverter.repos.ValuteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

@Controller
public class ConverterController {

    @Autowired
    private ValuteRepo valuteRepo;
    @Autowired
    private HistoryRepo historyRepo;

    @GetMapping("/authorization")
    public String authorization(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        XMLParser xmlParser = new XMLParser();
        ArrayList<Valute> valutes = xmlParser.readXMLData();

        valuteRepo.saveAll(valutes);

        return "authorization";
    }

    @GetMapping("/converter")
    public String converter(Model model) {
        Iterable<Valute> valutes = valuteRepo.findAll();

        model.addAttribute("valutes", valutes);
        model.addAttribute("history", new History());
        return "converter";
    }

    @PostMapping("/history")
    public String history(@ModelAttribute History history, Model model) {
        historyRepo.save(history);
        Iterable<History> histories = historyRepo.findAll();
        model.addAttribute("histories",histories);
        return "/history";
    }
}
