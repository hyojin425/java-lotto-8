package lotto.repository;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRepositoryTest {

    @DisplayName("저장한 로또와 조회한 로또가 일치한다")
    @Test
    void 저장한_로또와_조회한_로또가_일치한다() {
        // given
        LottoRepository lottoRepository = new LottoRepository();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        // when
        lottoRepository.save(lotto1);
        lottoRepository.save(lotto2);
        lottoRepository.save(lotto3);

        // then
        assertThat(lottoRepository.findAll().get(0)).isEqualTo(lotto1);
        assertThat(lottoRepository.findAll().get(1)).isEqualTo(lotto2);
        assertThat(lottoRepository.findAll().get(2)).isEqualTo(lotto3);
    }
}