package edu.home.translationservice.controller;

import edu.home.translationservice.proxy.translator.Translator;
import edu.home.translationservice.service.TranslationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping
    public String getTranslation(
        @RequestParam String text,
        @RequestParam("sl") String sourceLanguage,
        @RequestParam("dl") String destinationLanguage
    ) {
        return translationService.getTranslation(text, sourceLanguage, destinationLanguage);
    }
}
