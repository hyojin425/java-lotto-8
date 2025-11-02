package lotto.validator;

import static lotto.common.ExceptionMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.common.LottoConstants.LOTTO_PRICE;

public class LottoServiceValidator {

    public static void validatePurchaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
