/**
 * Blackjack player implementation 
 * @author Marcos J. Santana Miranda
 */
public class Player {
    
    /**
     * Player name
     */
     private String name;

     /**
      * Cards in player's current hand
      */
     private Card[] hand = new Card[10];

     /**
      * # of cards in player's hand
      */
     private int numCards;

     public Player(String aName){
        this.name = aName;

        //set player's hand to empty
        this.emptyHand();

     }
   
     /**
      * Reset player cards to zero
      */
     public void emptyHand(){
        for (int c = 0; c < 10; c++) {
            this.hand[c] = null;
        }
        this.numCards = 0;
     }

     /**
      * Add card to player's hand
      * @param aCard card to add
      * @return wheteher the sum of this new hand is <= 21
      */
     public boolean addCard(Card aCard){
        //print error if the number of cards is maxed
        if (this.numCards == 10) {
            System.err.printf("%s's hand already has 10 cards (max)!\n", this.name);
            System.exit(1);
        }
          //add new card in next slot and increment card counter
          this.hand[this.numCards] = aCard;
          this.numCards++;

          return (this.getHandSum() <= 21);
        }
     
        /**
         * Get sum of cards in player's hand
         * @return
         */
        public int getHandSum() {
            int handSum = 0;
            int cardNum = 0;
            int numAces = 0;
        
            for (int c = 0; c < this.numCards; c++) {
                cardNum = this.hand[c].getNumber();
        
                if (cardNum == 1) { // Ace
                    numAces++;
                    handSum += 1; // Consider the Ace as 1 initially
                } else if (cardNum > 10) {
                    handSum += 10; // Face cards have a value of 10
                } else {
                    handSum += cardNum;
                }
            }
        
            // Adjust Ace values if necessary to prevent busts
            while (numAces > 0 && handSum + 10 <= 21) {
                handSum += 10; // Consider an Ace as 11 only if it doesn't cause a bust
                numAces--;
            }
        
            return handSum;
        }
        

    /**
     * Print cardsin player's hand.
     * @param showFirstCard  wheter the first card is hiden or not
     */
    public void printHand(boolean showFirstCard)
    {
       System.out.printf("%s 's cards:\n", this.name);
       for (int c = 0; c < this.numCards; c++) {
        if ( c == 0 && !showFirstCard) {
            System.out.println(" [hidden] ");
        } else {
             System.out.printf(" %s\n", this.hand[c].toString());
        }
            }
       }
    }


