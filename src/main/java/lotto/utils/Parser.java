package lotto.utils;

import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    public static int parseStringAsInt(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public static List<String> parseWinningLotto(String winningLotto) {
        return List.of(winningLotto.split(DELIMITER));
    }
}
