// This is just an skeleton but I want this to be developed to the game simulator like blackjack

//Design Card

	   class Cards {
		   enum Types { SPADE, HEART, CLUB,  DIAMOND; }

		   void shuffle(int card[], int deck) {
			   int rand = Math.random() * deck; // Can use this Later

			   	for(int i = 0 ; i < deck; i++ ) {
			   		int card = (int) (i + Math.random() * deck);// one way to randomize
			   		//int card2 = Math.random() * (deck - i);
			   		// Swapping i and card;
			   		card[i] = card[i] ^ card[card];
			   		card[card] = card[i] ^ card[card];
			   	}
		   }

		   void blackJack() {

		   }
	   }
