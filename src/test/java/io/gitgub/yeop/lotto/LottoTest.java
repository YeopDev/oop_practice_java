package io.gitgub.yeop.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    @Test
    @DisplayName("로또 번호 생성")
    void createLottoNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("로또 번호 빈값 체크")
    void LottoNumbers_null_empty() {
        List<Integer> numbers = List.of();
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("랜덤값은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("로또 번호 길이 체크")
    void LottoNumbers_limit() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("랜덤 사이즈는 %d와 같아야 합니다. (현재 값 %d)".formatted(6, numbers.size()));
    }
}
