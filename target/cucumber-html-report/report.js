$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DrawCards.feature");
formatter.feature({
  "line": 2,
  "name": "draw card from a deck of cards",
  "description": "",
  "id": "draw-card-from-a-deck-of-cards",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@API"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "create a new deck and draw a card",
  "description": "",
  "id": "draw-card-from-a-deck-of-cards;create-a-new-deck-and-draw-a-card",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a new deck",
  "rows": [
    {
      "cells": [
        "requestURI"
      ],
      "line": 6
    },
    {
      "cells": [
        "http://deckofcardsapi.com/api/deck/new/shuffle/?deck_count\u003d1"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "get request to withdraw a card is made",
  "rows": [
    {
      "cells": [
        "requestURI"
      ],
      "line": 9
    },
    {
      "cells": [
        "http://deckofcardsapi.com/api/deck/\u003cdeck_id\u003e/draw"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the response contains withdrawn card",
  "rows": [
    {
      "cells": [
        "remaining"
      ],
      "line": 12
    },
    {
      "cells": [
        "51"
      ],
      "line": 13
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "WithdrawCardStepsDef.getNewDeck(DeckOfCardsRequest\u003e)"
});
formatter.result({
  "duration": 2085116329,
  "status": "passed"
});
formatter.match({
  "location": "WithdrawCardStepsDef.withdrawCard(DeckOfCardsRequest\u003e)"
});
formatter.result({
  "duration": 704887979,
  "status": "passed"
});
formatter.match({
  "location": "WithdrawCardStepsDef.validateResponse(DataTable)"
});
formatter.result({
  "duration": 1196986,
  "status": "passed"
});
formatter.uri("NewDeck.feature");
formatter.feature({
  "line": 2,
  "name": "To create a new deck of cards",
  "description": "",
  "id": "to-create-a-new-deck-of-cards",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@API"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "create a new deck",
  "description": "",
  "id": "to-create-a-new-deck-of-cards;create-a-new-deck",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a api endpoint",
  "rows": [
    {
      "cells": [
        "requestURI"
      ],
      "line": 6
    },
    {
      "cells": [
        "http://deckofcardsapi.com/api/deck/new/shuffle/?deck_count\u003d1"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "get request to create a new deck is sent",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the response contains",
  "rows": [
    {
      "cells": [
        "remaining",
        "success",
        "shuffled"
      ],
      "line": 10
    },
    {
      "cells": [
        "52",
        "true",
        "true"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "CreateNewDeckStepsDef.getApidetails(DeckOfCardsRequest\u003e)"
});
formatter.result({
  "duration": 2242784,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewDeckStepsDef.getNewDeck()"
});
formatter.result({
  "duration": 834969895,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewDeckStepsDef.validateResponse(DataTable)"
});
formatter.result({
  "duration": 747131,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "create a new deck with jokers",
  "description": "",
  "id": "to-create-a-new-deck-of-cards;create-a-new-deck-with-jokers",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "a api endpoint",
  "rows": [
    {
      "cells": [
        "requestURI"
      ],
      "line": 15
    },
    {
      "cells": [
        "http://deckofcardsapi.com/api/deck/new/shuffle"
      ],
      "line": 16
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "request to create a new deck is sent to include jokers",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the response contains",
  "rows": [
    {
      "cells": [
        "remaining",
        "success",
        "shuffled"
      ],
      "line": 19
    },
    {
      "cells": [
        "54",
        "true",
        "true"
      ],
      "line": 20
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "CreateNewDeckStepsDef.getApidetails(DeckOfCardsRequest\u003e)"
});
formatter.result({
  "duration": 294030,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewDeckStepsDef.getNewDeckWithJokers()"
});
formatter.result({
  "duration": 427014227,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewDeckStepsDef.validateResponse(DataTable)"
});
formatter.result({
  "duration": 858436,
  "status": "passed"
});
});