package lotto.domain;

import java.util.List;

public class LottoResult {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public LottoResult(List<Integer> numbers, Integer bonusNumber) {
        Lotto winningLotto = new Lotto(numbers);
        bonusNumberValidate(numbers, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberValidate(List<Integer> numbers, Integer bonusNumber) {
        if (!isBonusNumberNotDuplicated(numbers, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호에 보너스 번호와 중복된 숫자가 있습니다.");
        }

        if (!isBonusNumberValidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호는 1~45 사이의 정수입니다.");
        }
    }

    public boolean isBonusNumberNotDuplicated(List<Integer> numbers, Integer bonusNumber) {
        return !numbers.contains(bonusNumber);
    }

    public boolean isBonusNumberValidNumberRange(Integer bonusNumber) {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }
}
