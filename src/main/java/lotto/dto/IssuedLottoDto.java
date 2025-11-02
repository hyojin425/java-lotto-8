package lotto.dto;

import java.util.List;

public record IssuedLottoDto(List<LottoDto> lottoDtos, int amount) {
    public static IssuedLottoDto of(List<LottoDto> lottoDtos, int amount) {
        return new IssuedLottoDto(lottoDtos, amount);
    }
}
