package lotto.dto;

import lotto.domain.LottoRank;

public record LottoRankDto(int matchCount, int prize, int totalCount) {

    public static LottoRankDto from(LottoRank rank, int totalCount) {
        return new LottoRankDto(rank.getMatchCount(), rank.getPrize(), totalCount);
    }
}
