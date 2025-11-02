package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoRankDto;
import lotto.dto.LottoResultDto;
import lotto.repository.IssuedLottoRepository;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;
    private IssuedLottoRepository issuedLottoRepository;
    @BeforeEach
    void setUp() {
        lottoRepository = new LottoRepository();
        issuedLottoRepository = new IssuedLottoRepository();
        lottoService = new LottoService(lottoRepository, issuedLottoRepository);
    }

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        // given
        int purchaseAmount = 3000;

        // when
        IssuedLottoDto issuedLottoDto = lottoService.buyLottos(3000);

        // then
        assertThat(issuedLottoDto.amount()).isEqualTo(purchaseAmount / 1000);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외발생() {
        // given
        int invalidPurchaseAmount = 2500;

        // when & then
        assertThatThrownBy(() -> lottoService.buyLottos(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }

    @DisplayName("등수의 개수와 수익률을 계산한다.")
    @Test
    void 등수의_개수와_수익률을_계산한다() {
        // given
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4= new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        IssuedLotto issuedLotto = new IssuedLotto(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8), 8);
        issuedLottoRepository.save(issuedLotto);

        // when
        LottoResultDto lottoResultDto = lottoService.calculateLottoResult(winningLotto,bonusNumber);

        // then
        List<LottoRankDto> ranks = lottoResultDto.lottoRanks();

        assertThat(ranks.get(0).totalCount()).isEqualTo(1);
        assertThat(ranks.get(0).matchCount()).isEqualTo(3);

        assertThat(ranks.get(1).totalCount()).isEqualTo(0);
        assertThat(ranks.get(1).matchCount()).isEqualTo(4);

        assertThat(ranks.get(2).totalCount()).isEqualTo(0);
        assertThat(ranks.get(2).matchCount()).isEqualTo(5);

        assertThat(ranks.get(3).totalCount()).isEqualTo(0);
        assertThat(ranks.get(3).matchCount()).isEqualTo(5);

        assertThat(ranks.get(4).totalCount()).isEqualTo(0);
        assertThat(ranks.get(4).matchCount()).isEqualTo(6);

        assertThat(lottoResultDto.rate()).isEqualTo(62.5f);
    }
}