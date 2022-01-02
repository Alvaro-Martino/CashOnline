package api.muestra.cash.loanpageable;

import api.muestra.cash.repository.model.LoanPageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoanPageableController {

    @Autowired
    private LoanPageableAPI loanPageableAPI;

    @GetMapping(path = "/loans")
    public ResponseEntity<LoanPageableResponse> findAll(@RequestParam Map<String, Object> params){
        int page = params.get("page") != null ? Integer.parseInt(params.get("page").toString()) - 1 : 0;
        Long userId = params.get("user_id") != null ? Long.valueOf(params.get("user_id").toString()) : null;

        PageRequest pageRequest = PageRequest.of(page, Integer.parseInt(params.get("size").toString()));

        LoanPageableResponse response = loanPageableAPI.getAll(pageRequest, userId);

        if (response.getLoans().isEmpty()){
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }


    }

}
