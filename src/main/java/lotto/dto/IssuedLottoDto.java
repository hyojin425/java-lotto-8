package lotto.dto;

import lotto.domain.IssuedLotto;

import java.util.List;

import static lotto.utils.DtoConverter.convertToLottoDto;

public record IssuedLottoDto(List<LottoDto> lottoDtos, int amount) {
    public static IssuedLottoDto from(IssuedLotto issuedLotto) {
        return new IssuedLottoDto(convertToLottoDto(issuedLotto.getLottos()), issuedLotto.getAmount());
    }
}
