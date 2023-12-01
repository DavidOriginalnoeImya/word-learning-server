package edu.home.englishhelper.service.phrase.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Phrase {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String value;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Status status = Status.FIRST_REPETITION;

    @Setter(AccessLevel.NONE)
    private LocalDateTime timeToRepeat = LocalDateTime.now();

    private String translation;

    private String userGuid;

    public void updateStatus() {
        timeToRepeat = LocalDateTime.now().plusMinutes(status.getMinToNextStatus());
        status = status.getNextStatus();
    }
}
