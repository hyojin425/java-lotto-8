package lotto.dto;

import java.util.List;

public record LottoResultDto(List<LottoRankDto> lottoRanks, float rate) {

    public static LottoResultDto of(List<LottoRankDto> lottoRanks, float rate) {
        return new LottoResultDto(lottoRanks, rate);
    }
}