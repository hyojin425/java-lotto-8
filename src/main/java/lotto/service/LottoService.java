package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.utils.RandomNumberGenerator;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private final static int LOTTO_PRICE = 1000;
    private final Validator validator;

    public LottoService(Validator validator) {
        this.validator = validator;
    }

    public List<LottoDto> buyLottos(int purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);

        int count = purchaseAmount / LOTTO_PRICE;
        List<LottoDto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            purchasedLotto.add(generateLotto());
        }
        return Collections.unmodifiableList(purchasedLotto);
    }

    private LottoDto generateLotto() {
        Lotto lotto = new Lotto(RandomNumberGenerator.generateUniqueRandomNumber());
        return LottoDto.from(lotto);
    }
}
