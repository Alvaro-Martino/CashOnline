package api.muestra.cash.loanpageable;

import api.muestra.cash.repository.build.BuildLoanPage;
import api.muestra.cash.repository.LoanRepository;
import api.muestra.cash.repository.model.LoanPageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class LoanPageableService implements LoanPageableAPI {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BuildLoanPage buildLoanPage;

    @Override
    public LoanPageableResponse getAll(Pageable pageable, Long userId) {
        if (userId != null){
            try {
                return buildLoanPage.buildLoanPageToLoanResponse(loanRepository.findByUserId(userId, pageable));
            }catch (Exception e){
                throw new RestClientException(e.getMessage());
            }

        }else {
            try {
                return buildLoanPage.buildLoanPageToLoanResponse(loanRepository.findAll(pageable));
            }catch (Exception e){
                throw new RestClientException(e.getMessage());
            }

        }

    }
}
