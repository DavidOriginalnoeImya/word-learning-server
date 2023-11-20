package edu.home.translationservice.proxy.translator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "translator",
    url = "${translator.url}"
)
public interface Translator {

    @GetMapping("/get")
    TranslatorResponse translate(
        @RequestParam("q") String text,
        @RequestParam("langpair") String languages
    );
}
