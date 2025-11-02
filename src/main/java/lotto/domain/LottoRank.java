package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0)
    ;
    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if ((matchCount == rank.matchCount)
                    &&  (bonusMatch || !rank.requiresBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}
