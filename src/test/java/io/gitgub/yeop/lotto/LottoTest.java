package io.gitgub.yeop.lotto;

import io.gitgub.yeop.lotto.create.CreateLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    @Test
    @DisplayName("로또 번호 생성")
    void createLottoNumbers() {
        assertDoesNotThrow(() -> new Lotto(CreateLottoNumbers.AUTO.create(6)));
    }
}
