package racingcar.domain.game;

import racingcar.view.ErrorMessages;

public class Round {

    private static final int MINIMUM_POSITIVE_VALUE = 1;

    private final int value;
    private int played = 0;

    public Round(final int value) {
        validateIntegerValue(value);
        this.value = value;
    }

    public Round(final String value) {
        validateStringValue(value);
        this.value = Integer.parseInt(value);
    }

    private void validateStringValue(final String value) {
        try {
            validateIntegerValue(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_ROUND_NOT_INTEGER);
        }
    }

    private void validateIntegerValue(final int value) {
        validatePositive(value);
    }

    private void validatePositive(final int value) {
        if (value < MINIMUM_POSITIVE_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_ROUND_NOT_POSITIVE);
        }
    }

    public boolean playRound() {
        if (!allRoundPlayed()) {
            ++played;
            return true;
        }
        return false;
    }

    public boolean allRoundPlayed() {
        return played == value;
    }

    public int getPlayed() {
        return played;
    }
}
