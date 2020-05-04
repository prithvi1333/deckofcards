package deckofcards.cucumber.model;

import lombok.Data;

@Data
public class DeckOfCardsRequest {
    
    private String contentType;
    private String requestURI;
}
