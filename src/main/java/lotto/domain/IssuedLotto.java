package lotto.domain;

import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lottos;
    private final int purchasedAmount;

    public IssuedLotto(List<Lotto> lottos, int purchasedAmount) {
        this.lottos = lottos;
        this.purchasedAmount = purchasedAmount;
    }
}
