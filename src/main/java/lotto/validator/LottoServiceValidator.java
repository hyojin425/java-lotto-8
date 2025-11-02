package lotto.validator;

import static lotto.common.ExceptionMessage.INVALID_PURCHASE_AMOUNT;

public class LottoServiceValidator {

    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
