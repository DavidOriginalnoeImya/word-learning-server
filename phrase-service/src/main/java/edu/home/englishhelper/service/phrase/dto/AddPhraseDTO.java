package edu.home.englishhelper.service.phrase.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.home.englishhelper.service.phrase.model.Phrase;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddPhraseDTO {

    private String phrase;

    private String translation;

    @JsonIgnore
    private String userGuid;

    public Phrase toPhrase() {
        Phrase phrase = new Phrase();
        phrase.setValue(getPhrase());
        phrase.setTranslation(getTranslation());
        phrase.setUserGuid(getUserGuid());
        return phrase;
    }
}
