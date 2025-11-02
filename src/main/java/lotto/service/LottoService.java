package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.validator.LottoServiceValidator.validatePurchaseAmount;


public class LottoService {

    private final static int LOTTO_PRICE = 1000;

    public LottoService() {
    }

    public List<LottoDto> buyLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

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
