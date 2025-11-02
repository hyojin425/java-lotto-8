package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

    @DisplayName("당첨 로또 번호에 보너스 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호에_보너스_번호와_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("보너스 번호가 1~45 사이의 정수가 아닌 숫자면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1_45_사이의_정수가_아닌_숫자면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이의 정수");
    }
}