/**
 * Card implementation
 * @author Marcos J. Santana Miranda
 */
public class Card {
    /**
     * Card suit
     */
    private Suit cardSuit;

    /**
     * Card number
     */
    private int cardNum;

    /**
     * Card constructor
     * @param suit     card suit
     *@param number    card number
     */
     public Card(Suit suit, int number)
     {
        this.cardSuit = suit;

        if (number >= 1 && number <= 13){
            this.cardNum = number;
        } else {
            System.err.print(number + " is not a valid card number.");
            System.exit(1);
        }
        this.cardNum = number;
     }

     /**
      * 
      * @return card number
      */
     public int getNumber()
     {
        return cardNum;
     }

     public String toString()
     {
        String numStr = "Failure";

        switch(this.cardNum) {
        
            case 2 : 
            numStr = "Two";
            break;

             case 3: 
            numStr = "Three";
            break;

             case 4: 
            numStr = "Four";
            break;

             case 5: 
            numStr = "Five";
            break;

             case 6: 
            numStr = "Six";
            break;

             case 7: 
            numStr = "Seven";
            break;

             case 8: 
            numStr = "Eight";
            break;

             case 9: 
            numStr = "Nine";
            break;

             case 10: 
            numStr = "Ten";
            break;

             case 11: 
            numStr = "Jack";
            break;

             case 12: 
            numStr = "Queen";
            break;

             case 13: 
            numStr = "King";
            break;

             case 1: 
            numStr = "Ace";
            break;
        }
       return numStr + " of " + cardSuit.toString();
     }
}
