package com.sanbro.Authentication.Controller;

import com.sanbro.Authentication.DTO.APIResponseDTO;
import com.sanbro.Authentication.DTO.UserResponseDTO;
import com.sanbro.Authentication.Service.EmailVerificationService;
import com.sanbro.Authentication.Service.SignUpService;
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
    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserResponseDTO userResponseDTO){
        if(emailVerificationService.verifyEmail(userResponseDTO.getEmail())){
            APIResponseDTO apiResponseDTO = SignupService.signUp(userResponseDTO);
            return new ResponseEntity<> (apiResponseDTO.getMessage(), HttpStatusCode.valueOf(apiResponseDTO.getStatusCode()));
        }
        return new ResponseEntity<>("Invalid email address",HttpStatus.BAD_REQUEST);
//        APIResponseDTO apiResponseDTO = SignupService.signUp(userResponseDTO);
//        return new ResponseEntity<> (apiResponseDTO.getMessage(), HttpStatusCode.valueOf(apiResponseDTO.getStatusCode()));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserResponseDTO userResponseDTO){
        APIResponseDTO apiResponseDTO = SignupService.signIn(userResponseDTO);
        return new ResponseEntity<> (apiResponseDTO.getMessage(), HttpStatusCode.valueOf(apiResponseDTO.getStatusCode()));
    }
}
