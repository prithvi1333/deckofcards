package deckofcards.cucumber.stepsdef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import deckofcards.cucumber.model.DeckOfCardsRequest;

public class CreateNewDeckStepsDef extends BaseTest {

    @Given("^a api endpoint$")
    public void getApidetails(List<DeckOfCardsRequest> headers)
            throws Throwable {
        extractRequestDetails(headers.get(0));
    }

    @When("^get request to create a new deck is sent$")
    public void getNewDeck() throws Throwable {
        
        response = apiCommunicator.getRequest(cardsURI);
        Assert.assertNotNull(response);
        Assert.assertEquals("response code is not equal to 200", 200, response.extract().statusCode());
        Map<String, String> newDeck = response.extract().body().as(HashMap.class);
        setDeckId(newDeck.get("deck_id"));
        
    }

    @When("^request to create a new deck is sent to include jokers$")
    public void getNewDeckWithJokers() throws Throwable {
       
        cardsURI = String.join("?", cardsURI,"jokers_enabled=true");
        response = apiCommunicator.getRequest(cardsURI);
        Assert.assertNotNull(response);
        Assert.assertEquals("response code is not equal to 200", 200, response.extract().statusCode());
        ;
    }

    @Then("^the response contains$")
    public void validateResponse(DataTable dataTable) throws Throwable {
        
        final List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> newDeck = response.extract().body().as(HashMap.class);
        Assert.assertNotNull(newDeck);
        Assert.assertNotNull(newDeck.get("deck_id"));
        Assert.assertNotNull(newDeck.get("success"));
        Assert.assertNotNull(newDeck.get("remaining"));
        Assert.assertNotNull(newDeck.get("shuffled"));
        Assert.assertEquals(rows.get(0).get("remaining"), String.valueOf(newDeck.get("remaining")));
    }

}
