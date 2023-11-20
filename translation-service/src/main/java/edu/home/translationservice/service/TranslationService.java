package edu.home.translationservice.service;

import edu.home.translationservice.cache.Cache;
import edu.home.translationservice.cache.RedisCache;
import edu.home.translationservice.proxy.translator.Translator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TranslationService {

    private static final Logger logger = Logger.getLogger(TranslationService.class.getName());

    private final Translator translator;

    private final Cache<String, String> cache;

    public TranslationService(Translator translator, Cache<String, String> cache) {
        this.translator = translator;
        this.cache = cache;
    }

    public String getTranslation(String text, String sourceLanguage, String destinationLanguage) {
        String translation = cache.get(text);

        if (translation == null) {
            translation = translator
                    .translate(text, sourceLanguage + "|" + destinationLanguage)
                    .getResponseData().getTranslatedText();
            cache.save(text, translation);
        }

        return translation;
    }
}
