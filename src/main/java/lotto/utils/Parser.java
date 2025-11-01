package lotto.utils;

public class Parser {

    private static final String DELIMITER = ",";

    public static int parseStringAsInt(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }
}
