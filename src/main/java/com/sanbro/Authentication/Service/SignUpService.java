package com.sanbro.Authentication.Service;

import com.sanbro.Authentication.DTO.APIResponseDTO;
import com.sanbro.Authentication.DTO.UserResponseDTO;
import com.sanbro.Authentication.Entity.User;
import com.sanbro.Authentication.Repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;

    public APIResponseDTO signUp(UserResponseDTO userResponseDTO){
        User user = new User(userResponseDTO.getFirstName(),userResponseDTO.getLastName(),
                userResponseDTO.getEmail(),userResponseDTO.getPassword());
        if(user.getEmail()!=null && user.getLastName()!=null &&
        user.getFirstName()!=null && user.getPassword()!=null) {
            User save = signUpRepository.save(user);
            return new APIResponseDTO("user created successfully",201);
        }
        return new APIResponseDTO("mandatory fields missing",400);
    }

    public APIResponseDTO signIn(UserResponseDTO userResponseDTO){
        User user = new User(userResponseDTO.getFirstName(),userResponseDTO.getLastName(),
                userResponseDTO.getEmail(),userResponseDTO.getPassword());
        Optional<User> u = signUpRepository.findByEmail(user.getEmail());
        User uobj = u.orElseThrow(()-> new RuntimeException("User not found"));
        if(user.getEmail().equals(uobj.getEmail()) && user.getPassword().equals(uobj.getPassword())){
            return new APIResponseDTO("signin successful",200);
        }
        return new APIResponseDTO("Incorrect Password",403);
    }
}
