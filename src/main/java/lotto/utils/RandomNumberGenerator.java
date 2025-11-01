package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generateUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
