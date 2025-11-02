package lotto.repository;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IssuedLottoRepositoryTest {

    @DisplayName("저장한 발행 로또와 조회한 발행 로또가 일치한다")
    @Test
    void 저장한_발행_로또와_조회한_발행_로또가_일치한다() {
        // given
        IssuedLottoRepository issuedLottoRepository = new IssuedLottoRepository();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        IssuedLotto issuedLotto = new IssuedLotto(List.of(lotto1, lotto2, lotto3), 3000);

        // when
        issuedLottoRepository.save(issuedLotto);

        // then
        assertThat(issuedLottoRepository.find()).contains(issuedLotto);
    }
}