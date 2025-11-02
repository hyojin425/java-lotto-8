package lotto.dto;

import lotto.domain.LottoRank;

public record LottoRankDto(int matchCount, int prize, boolean bonusMatch, int totalCount) {

    public static LottoRankDto of(LottoRank rank, int totalCount) {
        return new LottoRankDto(rank.getMatchCount(), rank.getPrize(), rank.isRequiresBonus(), totalCount);
    }
}
