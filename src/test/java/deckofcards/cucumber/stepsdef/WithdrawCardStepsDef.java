package deckofcards.cucumber.stepsdef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import deckofcards.cucumber.model.DeckOfCardsRequest;

public class WithdrawCardStepsDef extends BaseTest {

    @When("^a new deck$")
    public void getNewDeck(List<DeckOfCardsRequest> request) throws Throwable {
        extractRequestDetails(request.get(0));
        response = apiCommunicator.getRequest(cardsURI);
        Assert.assertNotNull(response);
        Assert.assertEquals("response code is not equal to 200", 200, response.extract().statusCode());
        Map<String, String> newDeck = response.extract().body().as(HashMap.class);
        setDeckId(newDeck.get("deck_id"));
    }

    @When("^get request to withdraw a card is made$")
    public void withdrawCard(List<DeckOfCardsRequest> withdrawRequest) throws Throwable {
        extractRequestDetails(withdrawRequest.get(0));
        String  withdrawCardsUri = cardsURI.replace("<deck_id>", deckId);
        response = apiCommunicator.getRequest(withdrawCardsUri);
        Assert.assertNotNull(response);
        Assert.assertEquals("response code is not equal to 200", 200, response.extract().statusCode());
        ;
    }

    @Then("^the response contains withdrawn card$")
    public void validateResponse(DataTable dataTable) throws Throwable {
        
        final List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, Object> newDeck = response.extract().body().as(HashMap.class);
        Assert.assertNotNull(newDeck);
        Assert.assertNotNull(newDeck.get("deck_id"));
        Assert.assertNotNull(newDeck.get("success"));
        Assert.assertNotNull(newDeck.get("remaining"));
        Assert.assertEquals(rows.get(0).get("remaining"), String.valueOf(newDeck.get("remaining")));
        
        List<Map<String,Object>> cards = (List<Map<String, Object>>) newDeck.get("cards");
        Assert.assertNotNull("cards list empty ", cards);
        Assert.assertEquals(1, cards.size());
    }

}
