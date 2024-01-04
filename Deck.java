import java.util.Random;

/**
 * Card deck implementation
 * @author Marcos J. Santana  Miranda
 */
public class Deck {
    /**
     * Card array
     */
    private Card[] cards;

    /**
     * # of cards in deck
     */
    private int numCards;

    public Deck() {
        //call other constructor, define one deck with no shuffles
        this(1, false);
    }

    /**
     * Constructor that defines deck number and if it should be shuffled
     * @param numDecks
     * @param shuffle
     */
    public Deck(int numDecks, boolean shuffle)
    {
    this.numCards = numDecks * 52;
    this.cards = new Card[this.numCards];

    int cardIndex = 0;

    //for each deck
    for (int d = 0; d < numDecks;d++)
    {
        //for each suit
        for (int s = 0; s < 4; s++)
        {
            //for each number
            for (int n = 1; n <= 13; n++)
            {
                //add new card to deck
                this.cards[cardIndex] = new Card(Suit.values()[s], n);
                cardIndex++;
            }
        }
    }

    //shuffle if necessary
    if (shuffle) {
        this.shuffle();
    }
    }
    /**
     * Shuffle deck
     */
    public void shuffle() {
        //random int generator
        Random rand = new Random();

        //tmp card;
        Card tmp;

        int j;
        for (int i = 0; i < this.numCards; i++)
        {
            //rand card j swaps values with i
            j = rand.nextInt(this.numCards);
            
            //swap
            tmp = this.cards[i];
            this.cards[i] = this.cards[j];
            this.cards[j] = tmp;
        }
    }

    /**
     * Deal next card from deck
     * @return dealt card
     */
    public Card dealNextCard()
    {
        //get the top card
        Card top = this.cards[0];

        //shift subsequent cards to the left by one
        for (int c = 1; c < this.numCards; c++)
        {
            this.cards[c - 1] = this.cards[c];
        }
        this.cards[this.numCards-1] = null;

        //decrement cards in deck
        this.numCards--;

        return top;
    }
    /**
     * Print cards in deck
     * @param numToPrint
     */
    public void printDeck(int numToPrint){
        for (int c = 0; c < numToPrint; c++)
        {
            System.out.printf("%3d/%d %s \n", c+1, this.numCards, this.cards[c].toString());
        }
        System.out.printf("\t\t [%d other] \n", this.numCards-numToPrint);
    }

}
