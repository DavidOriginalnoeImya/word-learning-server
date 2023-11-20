package edu.home.translationservice.proxy.translator;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TranslatorResponse {

    private ResponseData responseData;

    @Setter @Getter
    public static class ResponseData {
        private String translatedText;
    }
}
