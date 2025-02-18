package com.sanbro.Authentication.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailVerificationService {
    private static final String API_URL = "https://api.kickbox.com/v2/verify";
    @Value("${email.verification.key}")
    private String API_KEY;

    public boolean verifyEmail(String email){
        String url = API_URL + "?email=" + email + "&apikey=" + API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response.contains("\"result\":\"deliverable\"");
    }
}
