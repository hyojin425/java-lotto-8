package lotto.domain;

import java.util.List;

import static lotto.validator.LottoValidator.*;

public class LottoResult {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public LottoResult(List<Integer> numbers, Integer bonusNumber) {
        Lotto winningLotto = new Lotto(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
