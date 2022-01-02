package api.muestra.cash.repository.build;

import api.muestra.cash.entity.LoanEntity;
import api.muestra.cash.entity.UserEntity;
import api.muestra.cash.repository.model.GetUsersServiceResponse;
import com.openapi.cash.model.Loan;
import com.openapi.cash.model.UserGetResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetUserBuilder {

    public GetUsersServiceResponse getUserToUser(UserEntity userEntity, List<LoanEntity> loanList, String codAnswer){

        GetUsersServiceResponse serviceResponse = new GetUsersServiceResponse();
        serviceResponse.setCodAnswer(codAnswer);
        if (codAnswer.equals("00")){
            UserGetResponse user = new UserGetResponse();

            user.setEmail(userEntity.getEmail());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());

            List<Loan> loans = new ArrayList<>();
            loanList.forEach(a -> {
                Loan loan = new Loan();
                loan.setId(BigDecimal.valueOf(a.getId()));
                loan.setTotal(a.getTotal());
                loan.setUserId(BigDecimal.valueOf(userEntity.getId()));
                loans.add(loan);
            });
            user.setLoans(loans);
            serviceResponse.setGetUserResponse(user);
            return serviceResponse;
        }else {
            return serviceResponse;
        }


    }

}
