package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }
}