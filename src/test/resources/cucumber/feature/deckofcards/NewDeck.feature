@API
Feature: To create a new deck of cards

  Scenario: create a new deck
    Given a api endpoint
      | requestURI                                                   |
      | http://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1 |
    When get request to create a new deck is sent
    Then the response contains 
      | remaining   | success            | shuffled |
      | 52          | true               | true     |

 Scenario: create a new deck with jokers
    Given a api endpoint
      | requestURI                                     |
      | http://deckofcardsapi.com/api/deck/new/shuffle |
    When request to create a new deck is sent to include jokers
    Then the response contains 
      | remaining   | success            | shuffled |
      | 54          | true               | true     |

  