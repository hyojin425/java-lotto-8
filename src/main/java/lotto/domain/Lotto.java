package lotto.domain;

import java.util.List;

import static lotto.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public LottoRank calculateRank(LottoResult lottoResult) {
        long matchCount = numbers.stream()
                .filter(lottoResult::isWinningNumber)
                .count();
        boolean bonusMatch = lottoResult.isBonusNumberIn(numbers);
        return LottoRank.valueOf((int) matchCount, bonusMatch);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
