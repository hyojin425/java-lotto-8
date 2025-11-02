package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 입력값이_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.isDigit("hyojin", "fieldName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }

    @DisplayName("당첨 로또 포맷이 숫자와 쉼표가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨_로또_포맷이_숫자와_쉼표가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningLottoFormat("3/4,r,9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자와 쉼표");
    }

    @DisplayName("값입력 값이 null 이거나 비어있는 경우 예외가 발생한다.")
    @Test
    void 입력_값이_null_이거나_비어있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(" ", "테스트 값"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있을 수 없습니다.");
    }
}