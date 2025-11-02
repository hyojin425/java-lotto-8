package lotto.domain;

import java.util.List;
import java.util.Set;

import static lotto.validator.LottoValidator.isNumberNotDuplicated;
import static lotto.validator.LottoValidator.isValidNumberRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (!isNumberNotDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        if (!isValidNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수입니다.");
        }
    }
}
