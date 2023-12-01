package edu.home.englishhelper.service.phrase.model;

import lombok.Getter;

import java.util.EnumMap;
import java.util.Map;

@Getter
enum Status {

    FIRST_REPETITION(5),
    SECOND_REPETITION(30),
    THIRD_REPETITION(1440),
    FOURTH_REPETITION(10080);

    private static final Map<Status, Status> nextStatus = new EnumMap<>(Status.class);
    static {
        nextStatus.put(FIRST_REPETITION, SECOND_REPETITION);
        nextStatus.put(SECOND_REPETITION, THIRD_REPETITION);
        nextStatus.put(THIRD_REPETITION, FOURTH_REPETITION);
        nextStatus.put(FOURTH_REPETITION, FOURTH_REPETITION);
    }

    private final long minToNextStatus;

    Status(long minToNextStatus) {
        this.minToNextStatus = minToNextStatus;
    }

    public Status getNextStatus() {
        return nextStatus.get(this);
    }
}
