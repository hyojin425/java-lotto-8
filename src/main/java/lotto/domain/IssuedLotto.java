package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.common.LottoConstants.LOTTO_PRICE;

public class IssuedLotto {

    private final List<Lotto> lottos;
    private final int amount;

    public IssuedLotto(List<Lotto> lottos, int amount) {
        this.lottos = lottos;
        this.amount = amount;
    }

    public Map<LottoRank, Long> rankCount(LottoResult lottoResult) {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(lottoResult))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public float calculateProfitRate(int totalPrize) {
        int purchaseAmount = amount * LOTTO_PRICE;
        float rate = (float) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 100) / 100.0f;
    }
}
