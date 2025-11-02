package lotto.repository;

import lotto.domain.IssuedLotto;

import java.util.Optional;

public class IssuedLottoRepository {

    private IssuedLotto issuedLotto;

    public void save(IssuedLotto issuedLotto) {
        this.issuedLotto = issuedLotto;
    }

    public Optional<IssuedLotto> find() {
        return Optional.ofNullable(issuedLotto);
    }
}
