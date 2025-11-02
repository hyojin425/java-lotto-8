package lotto.service;

import lotto.domain.LottoRank;
import lotto.dto.IssuedLottoDto;
import lotto.repository.IssuedLottoRepository;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        // given
        LottoRepository lottoRepository = new LottoRepository();
        IssuedLottoRepository issuedLottoRepository = new IssuedLottoRepository();
        LottoService lottoService = new LottoService(lottoRepository, issuedLottoRepository);
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
        LottoRepository lottoRepository = new LottoRepository();
        IssuedLottoRepository issuedLottoRepository = new IssuedLottoRepository();
        LottoService lottoService = new LottoService(lottoRepository, issuedLottoRepository);
        int invalidPurchaseAmount = 2500;

        // when & then
        assertThatThrownBy(() -> lottoService.buyLottos(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }

    @DisplayName("로또 수익률을 계산한다.")
    @Test
    void 로또_수익률을_계산한다() {
        // given
        LottoRepository lottoRepository = new LottoRepository();
        IssuedLottoRepository issuedLottoRepository = new IssuedLottoRepository();
        LottoService lottoService = new LottoService(lottoRepository, issuedLottoRepository);

        Map<LottoRank, Long> rankCount = new HashMap<>();
        rankCount.put(LottoRank.FIFTH, 1L);

        int amount = 8;

        // when
        double profitRate = lottoService.calculateProfitRate(rankCount, amount);

        // then
        assertThat(profitRate)
                .isGreaterThan(0)
                .isEqualTo(62.5);
    }
}