package lotto.utils;

public class Validator {

    private static final String IS_DIGIT_PATTERN = "^[0-9]+$";

    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void isDigit(String value) {
        if (!value.matches(IS_DIGIT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }
}
