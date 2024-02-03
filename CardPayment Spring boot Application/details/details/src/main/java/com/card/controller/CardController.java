package com.card.controller;

import com.card.entities.CardDetails;
import com.card.entities.PaymentResponse;
import com.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/card")
@CrossOrigin
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/getAllCards")
    public ResponseEntity<List<CardDetails>> getCard() {
        List<CardDetails> listOfCardDetails = null;
        try {
            listOfCardDetails = cardService.getCards();
            return new ResponseEntity<>(listOfCardDetails, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/makePayment")
        public PaymentResponse processPayment(@RequestBody CardDetails cardDetails) {
        PaymentResponse response = null;
        try {
            response = cardService.processPayment(cardDetails);
            return new ResponseEntity<>(response, HttpStatus.OK).getBody();
        }
        catch (Exception e) {
            e.getMessage();
        }
        return response;
    }
}
