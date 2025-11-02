package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 사이의 정수가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_1_45_사이의_정수가_아닌_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1,2,3,4,5,6 이고 당첨 번호가 1,2,3,7,8,9 이고 보너스 번호가 10일 경우 5등이다.")
    @Test
    void 로또_계산_테스트_5등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 7, 8, 9)), 10);

        // when
        LottoRank rank = lotto.calculateRank(lottoResult);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("로또 번호가 1,2,3,4,5,6 이고 당첨 번호가 1,2,3,4,8,9 이고 보너스 번호가 10일 경우 4등이다.")
    @Test
    void 로또_계산_테스트_4등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 8, 9)), 10);

        // when
        LottoRank rank = lotto.calculateRank(lottoResult);

        // then
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("로또 번호가 1,2,3,4,5,6 이고 당첨 번호가 1,2,3,4,5,9 이고 보너스 번호가 10일 경우 3등이다.")
    @Test
    void 로또_계산_테스트_3등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 9)), 10);

        // when
        LottoRank rank = lotto.calculateRank(lottoResult);

        // then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("로또 번호가 1,2,3,4,5,6 이고 당첨 번호가 1,2,3,4,5,9 이고 보너스 번호가 6일 경우 2등이다.")
    @Test
    void 로또_계산_테스트_2등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 9)), 6);

        // when
        LottoRank rank = lotto.calculateRank(lottoResult);

        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 번호가 1,2,3,4,5,6 이고 당첨 번호가 1,2,3,4,5,6 이고 보너스 번호가 7일 경우 2등이다.")
    @Test
    void 로또_계산_테스트_1등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        LottoRank rank = lotto.calculateRank(lottoResult);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }
}
