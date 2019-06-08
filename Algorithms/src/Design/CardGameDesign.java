class Card {
      String CardNo;
      int CardType; // 4 values
}

class Deck {
    int noOfCards;
    Card[noOfCards];
}

class Decks {
    int noofDecks;
    ArrayList<Decks> decks;
    ArrayList<String> NotAvailable;
    
    Decks(int decksCount){
        noofDecks = decksCount;
        for(int i = 0; i < decksCount; i++){
            decks.add(new Deck());
        }
    }
    
    Card randomCard() {
        int randNum = Math.random() * nofDecks * 52;
        int deckNo = randNum % noofDecks;
        int cardNo = randNum % 52;
        
        return decks.at(deckNo)[cardNo];
    }
}

class Player {
    
    
}

class Game {
    
    // Interface
}

class Backjack implements Game {
    Decks  deckOfCard = new Decks(4);
    ArrayList<Player> players = new ArrayList<Player>(5);   
    Initilize() {
        for(int i = 0; i < players.size(); i++) {
            int card1 = deckofCard.randomCard();
            int card2 = deckofCard.randomCard();
            players.at(i).Init(int card1, int card2);
        }
    }
   Play(){
       
   }
} 
