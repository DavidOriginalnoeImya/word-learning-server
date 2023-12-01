package edu.home.englishhelper.service.phrase.controller;

import edu.home.englishhelper.service.phrase.dto.AddPhraseDTO;
import edu.home.englishhelper.service.phrase.dto.PhraseDTO;
import edu.home.englishhelper.service.phrase.service.PhraseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phrases")
public class PhraseController {

    private static final String userGuid = "1";

    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping
    public ResponseEntity<List<PhraseDTO>> getPhrasesToRepeat() {
        return ResponseEntity
                .ok(phraseService.getPhrasesForRepeat(userGuid));
    }

    @PostMapping
    public ResponseEntity<PhraseDTO> addPhrase(@RequestBody AddPhraseDTO addPhraseDTO) {
        addPhraseDTO.setUserGuid(userGuid);
        return ResponseEntity
                .ok(phraseService.addPhrase(addPhraseDTO));
    }

    @PutMapping
    public ResponseEntity<List<PhraseDTO>> updatePhrases(@RequestBody List<PhraseDTO> phraseDTOList) {
        return ResponseEntity
                .ok(phraseService.updatePhrases(phraseDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePhrase(@PathVariable Long id) {
        phraseService.deletePhrase(id);
        return ResponseEntity
                .noContent().build();
    }
}
