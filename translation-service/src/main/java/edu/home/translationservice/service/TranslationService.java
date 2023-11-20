package edu.home.translationservice.service;

import edu.home.translationservice.proxy.translator.Translator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TranslationService {

    private final Translator translator;

    public TranslationService(Translator translator) {
        this.translator = translator;
    }

    public String getTranslation(String text, String sourceLanguage, String destinationLanguage) {
        return translator
                .translate(text, sourceLanguage + "|" + destinationLanguage)
                .getResponseData().getTranslatedText();
    }
}
