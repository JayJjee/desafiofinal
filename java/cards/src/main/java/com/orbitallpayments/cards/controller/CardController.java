package com.orbitallpayments.cards.controller;

import com.orbitallpayments.cards.domains.Card;
import com.orbitallpayments.cards.services.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardServices cardServices;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card){
        Card savedCard = cardServices.save(card);

        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll(){
        List<Card> cards = cardServices.findAll();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        Optional<Card> fetchedCard = cardServices.findById(id);

        return ResponseEntity.ok(fetchedCard.get());
    }

    @PutMapping("/{id}")
    public Card updateCard(@RequestBody Card card){
        return cardServices.updateCard(card);
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id){
        return cardServices.deleteCard(id);
    }
}
