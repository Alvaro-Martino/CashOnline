package api.muestra.cash.user;

import api.muestra.cash.repository.model.GetUsersServiceResponse;
import com.openapi.cash.api.UsersApi;
import com.openapi.cash.model.PostUserRequest;
import com.openapi.cash.model.PostUserResponse;
import com.openapi.cash.model.UserGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CashUserController implements UsersApi {

    @Autowired
    private CashUserService cashUserService;

    @Override
    public ResponseEntity<UserGetResponse> getUsers(BigDecimal id){
        Long userId = Long.valueOf(String.valueOf(id));
        GetUsersServiceResponse response = cashUserService.getUsers(userId);
        if (response.getCodAnswer().equals("00")){
            return new ResponseEntity<>(response.getGetUserResponse(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(response.getGetUserResponse(), HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<PostUserResponse> deleteUser(BigDecimal id) {
        Long userId = Long.valueOf(String.valueOf(id));
        PostUserResponse postUserResponse = cashUserService.deleteUser(userId);
        return new ResponseEntity<>(postUserResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostUserResponse> saveUsers(PostUserRequest postUserRequest) {
        PostUserResponse postUserResponse = cashUserService.saveUsers(postUserRequest);
        return new ResponseEntity<>(postUserResponse, HttpStatus.OK);
    }
}
