package com.card.serviceImpl;

import com.card.entities.CardDetails;
import com.card.entities.PaymentResponse;
import com.card.repository.CardRepository;
import com.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ThirdPartyPaymentService thirdPartyPaymentService;

    @Override
    public List<CardDetails> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public PaymentResponse processPayment(CardDetails cardDetails) {

        // Send payment details to a third-party API
        PaymentResponse thirdPartyResponse = thirdPartyPaymentService.processPayment(cardDetails);

        // Save card details securely
//        if (thirdPartyResponse.isSuccess()) {
//            CardDetails savedCard = new CardDetails(cardDetails.getName(), cardDetails.getCardNumber(),
//                    cardDetails.getExpirationDate(), cardDetails.getCvv());
//            cardRepository.save(savedCard);
//        }

        return thirdPartyResponse;
    }

}
