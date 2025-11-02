package lotto.validator;

import java.util.List;
import java.util.Set;

import static lotto.common.ExceptionMessage.*;
import static lotto.common.LottoConstants.*;

public class LottoValidator {

    public static void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        validIsBonusNumberNotDuplicated(numbers, bonusNumber);
        validIsBonusNumberValidNumberRange(bonusNumber);
    }

    public static void validIsBonusNumberNotDuplicated(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static void validIsBonusNumberValidNumberRange(Integer bonusNumber) {
        if (!(bonusNumber >= LOTTO_NUMBER_MIN_VALUE && bonusNumber <= LOTTO_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateLotto(List<Integer> numbers) {
        validateIsNumberNotDuplicated(numbers);
        validateNumberRange(numbers);
        validateNumberSize(numbers);
    }

    public static void validateIsNumberNotDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= LOTTO_NUMBER_MIN_VALUE && number <= LOTTO_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
}