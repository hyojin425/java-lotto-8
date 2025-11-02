package lotto.common;

public enum ExceptionMessage {
    INVALID_LOTTO_NUMBER_DUPLICATE("번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("번호는 1~45 사이의 정수여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_NOT_DIGIT("숫자가 아닙니다. 다시 입력해주세요."),
    INVALID_WINNING_LOTTO_FORMAT("숫자와 쉼표만 입력해야 합니다."),
    INPUT_EMPTY("비어있을 수 없습니다. 다시 입력해주세요"),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1000원 단위여야 합니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
