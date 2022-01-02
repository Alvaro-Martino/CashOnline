package api.muestra.cash.repository.model;

import api.muestra.cash.entity.LoanEntity;
import lombok.Data;

import java.util.List;

@Data
public class LoanPageableResponse {

    private List<LoanEntity> loans;
    private PageInfo pagInfo;
}
