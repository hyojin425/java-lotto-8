package lotto.validator;

public class InputValidator {

    private static final String IS_DIGIT_PATTERN = "^[0-9]+$";
    private static final String WINNING_LOTTO_PATTERN = "[\\d,]+";

    public static void isDigit(String value) {
        if (!value.matches(IS_DIGIT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }

    public static void validateWinningLottoFormat(String input) {
        validateNotEmpty(input, "당첨 번호");

        if (!input.matches(WINNING_LOTTO_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표만 입력해야 합니다.");
        }
    }

    public static void validateNotEmpty(String input, String fieldName) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] " + fieldName + "은(는) 비어있을 수 없습니다.");
        }
    }
}
