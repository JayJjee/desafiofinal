package com.orbitallpayments.cards.services;

import com.orbitallpayments.cards.domains.Card;
import com.orbitallpayments.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardServices {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card){
        return cardRepository.save(card);
    }

    public List<Card> findAll(){
        List<Card> cards = new ArrayList<>();
        cardRepository.findAll().forEach(cards::add);
        return cards;
    }

    public Optional<Card> findById(Long id){
        return cardRepository.findById(id);
    }

    public String deleteCard(Long id){
        cardRepository.deleteById(id);
        return "Card removed!" + id;
    }

    public Card updateCard(Card card){
        Card existingCard = cardRepository.findById(card.getId()).orElse(card);
        existingCard.setAddress(card.getAddress());
        existingCard.setCardNumber(card.getCardNumber());
        existingCard.setCity(card.getCity());
        existingCard.setCustomerName(card.getCustomerName());
        existingCard.setDocumentNumber(card.getDocumentNumber());
        existingCard.setEmbossName(card.getEmbossName());
        //existingCard.setId(card.getId()); //verificar
        existingCard.setMotherName(card.getMotherName());
        return cardRepository.save(existingCard);
    }
}
