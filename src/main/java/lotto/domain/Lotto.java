package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (isNumberNotDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        if (isValidNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수입니다.");
        }
    }

    public boolean isNumberNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == 6;
    }

    public boolean isValidNumberRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }
}
