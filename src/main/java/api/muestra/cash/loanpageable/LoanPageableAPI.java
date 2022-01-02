package api.muestra.cash.loanpageable;

import api.muestra.cash.repository.model.LoanPageableResponse;
import org.springframework.data.domain.Pageable;

public interface LoanPageableAPI {

    LoanPageableResponse getAll(Pageable pageable, Long userId);

}
