package lotto.validator;

import static lotto.common.ExceptionMessage.*;

public class InputValidator {

    private static final String IS_DIGIT_PATTERN = "^[0-9]+$";
    private static final String WINNING_LOTTO_PATTERN = "[\\d,]+";

    public static void isDigit(String value) {
        if (!value.matches(IS_DIGIT_PATTERN)) {
            throw new IllegalArgumentException(INVALID_NOT_DIGIT.getMessage());
        }
    }

    public static void validateWinningLottoFormat(String input) {
        validateNotEmpty(input, "당첨 번호");

        if (!input.matches(WINNING_LOTTO_PATTERN)) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_FORMAT.getMessage());
        }
    }

    public static void validateNotEmpty(String input, String fieldName) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_EMPTY.getMessage() + " : " + fieldName);
        }
    }
}
