package com.card.serviceImpl;

import com.card.entities.CardDetails;
import com.card.entities.PaymentResponse;
import org.springframework.web.client.RestTemplate;

public class ThirdPartyPaymentService {

    private final String THIRD_PARTY_API_URL = "https://api.com/processPayment/thirdPartyApi";

    public PaymentResponse processPayment(CardDetails cardDetails) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            PaymentResponse thirdPartyResponse = restTemplate.postForObject(THIRD_PARTY_API_URL, cardDetails, PaymentResponse.class);

            return thirdPartyResponse;
        } catch (Exception e) {
            // Handle exceptions or errors during the payment process
            e.getMessage();
        }
        return null;
    }
}
