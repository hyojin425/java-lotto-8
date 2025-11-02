package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.validator.InputValidator;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getPurchaseAmount() {
        String purchaseAmountAsString = Console.readLine();
        InputValidator.isDigit(purchaseAmountAsString, "구매 금액");
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
        InputValidator.isDigit(bonusNumber, "보너스 번호");
        return Parser.parseStringAsInt(bonusNumber);
    }
}
