package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.common.LottoConstants.*;

public class RandomNumberGenerator {

    public static List<Integer> generateUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE, NUMBER_COUNT);
    }
}
