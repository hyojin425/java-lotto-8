package lotto.validator;

import java.util.List;
import java.util.Set;

public class LottoValidator {

    final static int NUMBER_SIZE = 6;
    final static int LOTTO_NUMBER_MIN_VALUE = 1;
    final static int LOTTO_NUMBER_MAX_VALUE = 45;

    public static void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        validIsBonusNumberNotDuplicated(numbers, bonusNumber);
        validIsBonusNumberValidNumberRange(bonusNumber);
    }

    public static void validIsBonusNumberNotDuplicated(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호에 보너스 번호와 중복된 숫자가 있습니다.");
        }
    }

    public static void validIsBonusNumberValidNumberRange(Integer bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호는 1~45 사이의 정수입니다.");
        }
    }

    public static void validateLotto(List<Integer> numbers) {
        validateIsNumberNotDuplicated(numbers);
        validateNumberRange(numbers);
        validateNumberSize(numbers);
    }

    public static void validateIsNumberNotDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= LOTTO_NUMBER_MIN_VALUE && number <= LOTTO_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수입니다.");
        }
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
