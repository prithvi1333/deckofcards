package deckofcards.cucumber.stepsdef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import deckofcards.cucumber.apicommunicator.ApiCommunicator;
import deckofcards.cucumber.model.DeckOfCardsRequest;
import io.restassured.response.ValidatableResponse;

@ContextConfiguration("classpath:config/deckofcards-automation-context.xml")
public class BaseTest {
    
    @Autowired protected ApiCommunicator apiCommunicator;
    public String contentType = "";
    public String cardsURI = "";
    public String deckId = "";
    ValidatableResponse response = null;
   
    public void extractRequestDetails(DeckOfCardsRequest deckOfCardsRequest) {
        cardsURI = deckOfCardsRequest.getRequestURI();
        contentType = deckOfCardsRequest.getContentType();
     }
    
   public void  setDeckId(String deckId){
        this.deckId = deckId;
    }

}
