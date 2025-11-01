package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.utils.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getPurchaseAmount() {
        String purchaseAmountAsString = Console.readLine();
        Validator.isDigit(purchaseAmountAsString);
        return Parser.parseStringAsInt(purchaseAmountAsString);
    }

    public List<Integer> getWinningLotto() {
        String winningLotto = Console.readLine();
        Validator.validateWinningLottoFormat(winningLotto);

        List<String> winningLottoAsString =  Parser.parseWinningLotto(winningLotto);
        return winningLottoAsString.stream()
                .map(number -> Parser.parseStringAsInt(number))
                .collect(Collectors.toList());
    }
}
