package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.validator.InputValidator;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getPurchaseAmount() {
        String purchaseAmountAsString = Console.readLine();
        InputValidator.validateNotEmpty(purchaseAmountAsString, "구매 금액");
        InputValidator.isDigit(purchaseAmountAsString);
        return Parser.parseStringAsInt(purchaseAmountAsString);
    }

    public List<Integer> getWinningLotto() {
        String winningLotto = Console.readLine();
        InputValidator.validateWinningLottoFormat(winningLotto);

        List<String> winningLottoAsString =  Parser.parseWinningLotto(winningLotto);
        return winningLottoAsString.stream()
                .map(number -> Parser.parseStringAsInt(number))
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        String bonusNumber = Console.readLine();
        InputValidator.validateNotEmpty(bonusNumber, "보너스 번호");
        InputValidator.isDigit(bonusNumber);
        return Parser.parseStringAsInt(bonusNumber);
    }
}
