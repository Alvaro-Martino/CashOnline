package api.muestra.cash.user;

import api.muestra.cash.entity.LoanEntity;
import api.muestra.cash.entity.UserEntity;
import api.muestra.cash.repository.LoanRepository;
import api.muestra.cash.repository.UserRepository;
import api.muestra.cash.repository.build.GetUserBuilder;
import api.muestra.cash.repository.model.GetUsersServiceResponse;
import com.openapi.cash.model.PostUserRequest;
import com.openapi.cash.model.PostUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CashUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GetUserBuilder getUserBuilder;

    @Autowired
    private LoanRepository loanRepository;


    public GetUsersServiceResponse getUsers(Long userId){
        Optional<UserEntity> user;
        UserEntity userEntity = new UserEntity();
        List<LoanEntity> loans = new ArrayList<>();
        String codAnswer;
        try {
            user = userRepository.findById(userId);
            if (user.isPresent()){
                codAnswer = "00";
                userEntity = user.get();
                loans = loanRepository.getLoans(user.get().getId());
            }else {
                codAnswer = "10";
            }
        }catch (Exception e){
            throw new RestClientException(e.getMessage());
        }



        return getUserBuilder.getUserToUser(userEntity, loans, codAnswer);
    }

    public PostUserResponse deleteUser(Long userId){
        PostUserResponse response;
        try {
            Optional<UserEntity> user = userRepository.findById(userId);
            List<LoanEntity> loans;
            if (user.isPresent()){
                loans = loanRepository.getLoans(user.get().getId());
                    if (!loans.isEmpty()){
                        loanRepository.deleteLoansByUserId(userId);
                    }
                userRepository.deleteById(userId);
                response = createResponse("00","OK");
            }else {
                response = createResponse("10","No habia usuarios con ese userId");
            }

        }catch(Exception e){
            throw new RestClientException(e.getMessage());
        }
        return response;
    }

    public PostUserResponse saveUsers(PostUserRequest postUserRequest){

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(postUserRequest.getEmail());
        userEntity.setFirstName(postUserRequest.getFirstName());
        userEntity.setLastName(postUserRequest.getLastName());

        try {
            userRepository.save(userEntity);
        }catch (Exception e){
            throw new RestClientException(e.getMessage());
        }


        return createResponse("00", "OK");
    }


    private PostUserResponse createResponse( String code, String message) {
        PostUserResponse postUserResponse = new PostUserResponse();
        postUserResponse.setCode(code);
        postUserResponse.setMessage(message);
        return postUserResponse;
    }

}
