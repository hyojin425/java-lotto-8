package lotto.validator;

import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static boolean isBonusNumberNotDuplicated(List<Integer> numbers, Integer bonusNumber) {
        return !numbers.contains(bonusNumber);
    }

    public static boolean isBonusNumberValidNumberRange(Integer bonusNumber) {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }

    public static boolean isNumberNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == 6;
    }

    public static boolean isValidNumberRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }
}
