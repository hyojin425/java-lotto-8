package lotto.domain;

import java.util.List;

import static lotto.validator.LottoValidator.*;

public class LottoResult {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public LottoResult(Lotto winningLotto, Integer bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainNumber(int number) {
        return winningLotto.contains(number);
    }

    public boolean hasBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
