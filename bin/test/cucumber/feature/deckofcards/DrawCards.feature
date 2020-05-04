@API
Feature: draw card from a deck of cards

  Scenario: create a new deck and draw a card
    Given a new deck
      | requestURI                                                   |
      | http://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1 |
    When get request to withdraw a card is made
      | requestURI                                        |
      | http://deckofcardsapi.com/api/deck/<deck_id>/draw |
    Then the response contains withdrawn card
    | remaining |
    | 51		|  


  