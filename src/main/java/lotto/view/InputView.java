package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.utils.Validator;

public class InputView {

    public int getPurchaseAmount() {
        String purchaseAmountAsString = Console.readLine();
        Validator.isDigit(purchaseAmountAsString);
        return Parser.parsePurchaseAmountAsInt(purchaseAmountAsString);
    }
}
