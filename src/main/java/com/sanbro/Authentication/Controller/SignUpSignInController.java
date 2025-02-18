package com.sanbro.Authentication.Controller;

import com.sanbro.Authentication.DTO.APIResponseDTO;
import com.sanbro.Authentication.DTO.UserResponseDTO;
import com.sanbro.Authentication.Entity.User;
import com.sanbro.Authentication.Service.SignUpService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SignUpSignInController {
    @Autowired
    private SignUpService SignupService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserResponseDTO userResponseDTO){
        APIResponseDTO apiResponseDTO = SignupService.signUp(userResponseDTO);
        return new ResponseEntity<> (apiResponseDTO.getMessage(), HttpStatusCode.valueOf(apiResponseDTO.getStatusCode()));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserResponseDTO userResponseDTO){
        APIResponseDTO apiResponseDTO = SignupService.signIn(userResponseDTO);
        return new ResponseEntity<> (apiResponseDTO.getMessage(), HttpStatusCode.valueOf(apiResponseDTO.getStatusCode()));
    }
}
