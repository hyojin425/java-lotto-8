package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

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
}
