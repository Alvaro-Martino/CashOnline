package api.muestra.cash.repository.model;

import com.openapi.cash.model.UserGetResponse;
import lombok.Data;

@Data
public class GetUsersServiceResponse {

    private UserGetResponse getUserResponse;
    private String codAnswer;

}
