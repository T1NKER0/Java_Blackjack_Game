import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {

        // Initialize
        Scanner input = new Scanner(System.in);
        Deck theDeck = new Deck(1, true);

        // Initialize player objects
        Player me = new Player("Player");
        Player dealer = new Player("Dealer");

        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        // Print initial hands
        System.out.println("Cards are dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        // Flags for when each player is finished hitting
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while (!meDone || !dealerDone) {
            // Player's turn
            if (!meDone) {
                if (me.getHandSum() == 21) {
                    System.out.println("You've reached 21! You win!\n");
                    meDone = true;
                    break;
                }

                System.out.print("Hit or Stay? (Enter H or S)");
                ans = input.next();
                System.out.println();

                // If the player hits
                if (ans.compareToIgnoreCase("H") == 0) {
                    // Add next card in the deck and store whether the player is busted
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);

                    // Check if the player is busted
                    if (me.getHandSum() > 21) {
                        meDone = true;
                        System.out.println("You're busted! The dealer wins.\n");
                        break; // End the game immediately as player busts
                    }
                } else {
                    meDone = true;
                }
            }

            // Dealer's turn
            if (!dealerDone) {
                if (dealer.getHandSum() < 17) {
                    System.out.println("The Dealer hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                } else {
                    dealerDone = true;
                }

                // Check if the dealer is busted
                if (dealer.getHandSum() > 21) {
                    dealerDone = true;
                    System.out.println("Dealer is busted! You win!\n");
                    break; // End the game immediately as dealer busts
                }
            }
        }
        System.out.println();

        // Close Scanner
        input.close();

        // Print final hands and sums
        me.printHand(true);
        dealer.printHand(true);

        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        System.out.println("Your hand value: " + mySum);
        System.out.println("Dealer's hand value: " + dealerSum);

        if (mySum == 21) {
            System.out.println("You've reached 21! You win!\n");
        } else if (mySum <= 21 && (mySum > dealerSum || dealerSum > 21)) {
            System.out.println("You win!\n");
        } else {
            System.out.println("Dealer wins!\n");
        }
    }
}
