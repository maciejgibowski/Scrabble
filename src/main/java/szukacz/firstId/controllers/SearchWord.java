package szukacz.firstId.controllers;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import szukacz.firstId.entity.WordEntity;
import szukacz.firstId.repository.SearchDatabase;

@Controller
@RequestMapping("/word")
public class SearchWord {

    @Autowired
    private SearchDatabase searchDatabase;

    @GetMapping("/wordSearch")
    public String wordSearch(Model model) {
        return "SearchWordForm";
    }

    @PostMapping("/wordSearch")
    public String wordSearch(@RequestParam String wordAsk, Model model) {

        List<WordEntity> wordEntity = this.searchDatabase.findByPart(wordAsk);

        model.addAttribute("wordAsk", "Twoje słowo: \"" + wordAsk + "\" można użyć w grze.");

        model.addAttribute("wordAskList", wordEntity);

        if (wordEntity.isEmpty()) {

        	model.addAttribute("wordAsk", "Twojego słowa: \"" + wordAsk + "\" nie można użyć w grze.");
            return "SearchWordForm";
        }

        return "SearchWordForm";

    }

    @GetMapping("/wordSearchOnRandomLetters")
    public String wordSearchOnRandomLetters(Model model) {
        return "wordSearchOnRandomLetters";
    }

    @PostMapping("/wordSearchOnRandomLetters")
    public String wordSearchOnRandomLetters(@RequestParam String wordAsk, @RequestParam int numberOfAdditionalLetters,
            Model model) {

        int numberOfLetters = wordAsk.length() + numberOfAdditionalLetters;

        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] split = wordAsk.split("");
        Arrays.sort(split, collator);
        String querySet = "";
        for (int i = 0; i < split.length; i++) {
            querySet += (split[i] + "%");
        }

        List<WordEntity> wordEntity = this.searchDatabase.findWOrdSearchOnRandomLettersByPart(querySet,
                numberOfLetters);

        model.addAttribute("wordAsk", wordAsk);

        model.addAttribute("wordAskList", wordEntity);

        if (wordEntity.isEmpty()) {

            return "wordSearchOnRandomLetters";
        }

        model.addAttribute("wordAsk", "Posiadasz litery: \"" + wordAsk + "\"");

        
        return "wordSearchOnRandomLetters";

    }

} 