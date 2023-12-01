package edu.home.englishhelper.service.phrase.service;

import edu.home.englishhelper.service.phrase.dto.AddPhraseDTO;
import edu.home.englishhelper.service.phrase.dto.PhraseDTO;
import edu.home.englishhelper.service.phrase.model.Phrase;
import edu.home.englishhelper.service.phrase.model.PhraseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PhraseService {

    private static final Logger logger = Logger.getLogger(PhraseService.class.getName());

    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public PhraseDTO addPhrase(AddPhraseDTO addPhraseDTO) {
        Phrase phrase = phraseRepository.save(addPhraseDTO.toPhrase());
        return PhraseDTO.getPhraseDTO(phrase);
    }

    public PhraseDTO updatePhrase(PhraseDTO phraseDTO) {
        Phrase phrase = phraseRepository.findById(phraseDTO.getId()).orElseThrow();
        phrase.updateStatus();
        return PhraseDTO.getPhraseDTO(phraseRepository.save(phrase));
    }

    public List<PhraseDTO> updatePhrases(List<PhraseDTO> phraseDTOList) {
        return phraseDTOList.stream()
                .map(this::updatePhrase)
                .collect(Collectors.toList());
    }

    public List<PhraseDTO> getPhrasesForRepeat(String userGuid) {
        return phraseRepository
                .getPhrasesForRepeat(LocalDateTime.now(), userGuid, PageRequest.of(0, 50))
                .stream()
                .map(PhraseDTO::getPhraseDTO)
                .collect(Collectors.toList());
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }
}
