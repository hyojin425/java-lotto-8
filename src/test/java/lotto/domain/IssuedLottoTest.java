package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IssuedLottoTest {

    @DisplayName("발행 로또에서 각 등수의 수를 계산한다.")
    @Test
    void 발행_로또에서_각_등수의_수를_계산한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4= new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        IssuedLotto issuedLotto = new IssuedLotto(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8), 8);
        LottoResult lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Map<LottoRank, Long> rankCount = issuedLotto.rankCount(lottoResult);

        // then
        assertThat(rankCount.getOrDefault(LottoRank.FIRST, 0L)).isEqualTo(0L);
        assertThat(rankCount.getOrDefault(LottoRank.SECOND, 0L)).isEqualTo(0L);
        assertThat(rankCount.getOrDefault(LottoRank.THIRD, 0L)).isEqualTo(0L);
        assertThat(rankCount.getOrDefault(LottoRank.FOURTH, 0L)).isEqualTo(0L);
        assertThat(rankCount.getOrDefault(LottoRank.FIFTH, 0L)).isEqualTo(1L);
    }
}