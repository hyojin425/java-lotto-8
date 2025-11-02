package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.repository.LottoRepository;
import lotto.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.LottoConstants.LOTTO_PRICE;
import static lotto.validator.LottoServiceValidator.validatePurchaseAmount;


public class LottoService {

    final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<LottoDto> buyLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int count = purchaseAmount / LOTTO_PRICE;

        saveRandomLottos(count);

        return convertToLottoDto(lottoRepository.findAll());
    }

    private void saveRandomLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottoRepository.save(generateLotto());
        }
    }

    private Lotto generateLotto() {
        return new Lotto(RandomNumberGenerator.generateUniqueRandomNumber());
    }

    private List<LottoDto> convertToLottoDto(List<Lotto> lottos) {
        return lottos.stream()
                .map(LottoDto::from)
                .collect(Collectors.toList());
    }
}
