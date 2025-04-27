// Eric Chang
//25 SPRING-CIS-18A-42515
//Programming assignment 6
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class testRun{
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM-dd-yyyy , (HH:mm:ss a)");
        String Date_and_time = now.format(formatter);

        //int and shuff deck
        DeckofCards cardDeck = new DeckofCards();
        cardDeck.shuffleCards(); // Randomize card order
        //deal 5 cards
        Card[] playerHand = new Card[5];
        for (int index = 0; index < playerHand.length; index++) {
            playerHand[index] = cardDeck.dealOneCard();
            System.out.printf("Card %d: %s%n", index + 1, playerHand[index]);
        }

        System.out.println("\nEvaluating your hand");
        System.out.println("You have:\n");
        int pairCount = cardDeck.findPairs(playerHand); 
        cardDeck.checkTwoPairs(pairCount); 

        int tripleCount = cardDeck.findThreeOfAKind(playerHand); 
        cardDeck.findFourOfAKind(playerHand); 
        cardDeck.checkFlush(playerHand); 
        cardDeck.checkStraight(playerHand); 
        cardDeck.checkFullHouse(pairCount, tripleCount);
        System.out.println("...\n");
        System.out.println("Best of luck..\n");

        System.out.println("\nThanks for playing Eric's Card Game!\n");
        System.out.print("Time of Calculation is: " + Date_and_time+"\n");
        System.exit(0);
    }
}
    


            