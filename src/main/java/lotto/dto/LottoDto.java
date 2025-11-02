package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public record LottoDto(List<Integer> numbers, int amount) {
    public static LottoDto from(Lotto lotto, int amount) {
        return new LottoDto(lotto.getNumbers(), amount);
    }
}
