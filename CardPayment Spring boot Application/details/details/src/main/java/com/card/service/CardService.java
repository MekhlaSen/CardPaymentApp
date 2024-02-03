package com.card.service;

import com.card.entities.CardDetails;
import com.card.entities.PaymentResponse;

import java.util.List;

public interface CardService {

    List<CardDetails> getCards();

    public PaymentResponse processPayment(CardDetails cardDetails) ;

}
