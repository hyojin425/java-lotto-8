package lotto.service;

import lotto.dto.LottoDto;
import lotto.validator.InputValidator;
import lotto.validator.LottoServiceValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        // given
        LottoService lottoService = new LottoService();
        int purchaseAmount = 3000;

        // when
        List<LottoDto> lottos = lottoService.buyLottos(3000);

        // then
        assertThat(lottos.size()).isEqualTo(purchaseAmount / 1000);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외발생() {
        // given
        LottoService lottoService = new LottoService();
        int invalidPurchaseAmount = 2500;

        // when & then
        assertThatThrownBy(() -> lottoService.buyLottos(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }
}