package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoResultDto;
import lotto.repository.IssuedLottoRepository;
import lotto.repository.LottoRepository;
import lotto.utils.RandomNumberGenerator;

import java.util.List;
import java.util.Map;

import static lotto.common.ExceptionMessage.ISSUED_LOTTO_NOT_FOUND;
import static lotto.common.LottoConstants.LOTTO_PRICE;
import static lotto.utils.DtoConverter.convertToIssuedLottoDto;
import static lotto.utils.DtoConverter.convertToLottoRankDto;
import static lotto.validator.LottoServiceValidator.validatePurchaseAmount;


public class LottoService {

    final LottoRepository lottoRepository;
    final IssuedLottoRepository issuedLottoRepository;

    public LottoService(LottoRepository lottoRepository, IssuedLottoRepository issuedLottoRepository) {
        this.lottoRepository = lottoRepository;
        this.issuedLottoRepository = issuedLottoRepository;
    }

    public IssuedLottoDto buyLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int amount = purchaseAmount / LOTTO_PRICE;

        saveRandomLottos(amount);
        saveIssuedLotto(lottoRepository.findAll(), amount);

        IssuedLotto issuedLotto = issuedLottoRepository.find()
                .orElseThrow(() -> new IllegalStateException(ISSUED_LOTTO_NOT_FOUND.getMessage()));

        return convertToIssuedLottoDto(issuedLotto);
    }

    private void saveRandomLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            lottoRepository.save(generateLotto());
        }
    }

    private Lotto generateLotto() {
        return new Lotto(RandomNumberGenerator.generateUniqueRandomNumber());
    }

    private void saveIssuedLotto(List<Lotto> lottos, int amount) {
        issuedLottoRepository.save(new IssuedLotto(lottos, amount));
    }

    public LottoResultDto getLottoResult(List<Integer> winningLotto, int bonusNumber) {
        LottoResult lottoResult = new LottoResult(winningLotto, bonusNumber);
        IssuedLotto issuedLotto = issuedLottoRepository.find()
                .orElseThrow(() -> new IllegalArgumentException(ISSUED_LOTTO_NOT_FOUND.getMessage()));

        Map<LottoRank, Long> rankCount = issuedLotto.rankCount(lottoResult);
        int totalPrize = getTotalPrize(rankCount);
        float rate = issuedLotto.calculateProfitRate(totalPrize);

        return LottoResultDto.of(convertToLottoRankDto(rankCount), rate);
    }

    private int getTotalPrize(Map<LottoRank, Long> rankCount) {
        return rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue().intValue())
                .sum();
    }
}
