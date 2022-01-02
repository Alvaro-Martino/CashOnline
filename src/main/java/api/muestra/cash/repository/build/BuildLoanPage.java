package api.muestra.cash.repository.build;

import api.muestra.cash.entity.LoanEntity;
import api.muestra.cash.repository.model.LoanPageableResponse;
import api.muestra.cash.repository.model.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class BuildLoanPage {

    public LoanPageableResponse buildLoanPageToLoanResponse(Page<LoanEntity> loanEntityPage){
        LoanPageableResponse response = new LoanPageableResponse();
        PageInfo pageInfo = new PageInfo();

        response.setLoans(loanEntityPage.getContent());

        pageInfo.setPage(loanEntityPage.getNumber() + 1);
        pageInfo.setSize(loanEntityPage.getSize());
        pageInfo.setTotalPages(loanEntityPage.getTotalPages());
        pageInfo.setTotalElements(loanEntityPage.getTotalElements());

        response.setPagInfo(pageInfo);

        return response;
    }


}
