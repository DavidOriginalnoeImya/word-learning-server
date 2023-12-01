package edu.home.englishhelper.service.phrase.dto;

import edu.home.englishhelper.service.phrase.model.Phrase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhraseDTO {

    private Long id;

    private String phrase;

    private String translation;

    public static PhraseDTO getPhraseDTO(Phrase phrase) {
        return new PhraseDTO(
                phrase.getId(),
                phrase.getValue(),
                phrase.getTranslation()
        );
    }
}
