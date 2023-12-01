package edu.home.englishhelper.service.phrase.model;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {

    @Query("select p from Phrase p where p.timeToRepeat <= ?1 and p.userGuid = ?2")
    List<Phrase> getPhrasesForRepeat(LocalDateTime now, String userGuid);

    @Query(
            "select p from Phrase p " +
            "where p.timeToRepeat <= ?1 and p.userGuid = ?2 " +
            "order by p.status desc, p.timeToRepeat asc"
    )
    List<Phrase> getPhrasesForRepeat(LocalDateTime now, String userGuid, PageRequest pageRequest);
}
