
import java.util.Random;
import java.util.Arrays;

public class DeckofCards{
    private static final String[] FACES = {
        "King", "Queen", "Jack", "Ace", "Deuce", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten"
    };
    private static final String[] SUITS = {"Clubs", "Hearts", "Spades", "Diamonds"};
    private Card[] deck;
    private static final Random randomNum = new Random();
    private int currentCard;
    private static final int TOTAL_CARDS = 52;
    // Constructor 
    public DeckofCards() {
        deck = new Card[TOTAL_CARDS];
        currentCard = 0;

        // Fill deck with cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(FACES[i % 13], SUITS[i / 13]);
        }
    }
    // Shuffles card
    public void shuffleCards() {
        currentCard = 0;

        for (int i = 0; i < deck.length; i++) {
            int randomIndex = randomNum.nextInt(TOTAL_CARDS);
            Card tempCard = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = tempCard;
        }
    }
    // Deal single card
    public Card dealOneCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        }
        return null;
    }
    // Counts frequency
    private int[] countFaces(Card[] hand) {
        int[] faceCounts = new int[FACES.length];

        // Reset counts
        Arrays.fill(faceCounts, 0);

        // Tally faces
        for (Card card : hand) {
            for (int i = 0; i < FACES.length; i++) {
                if (card.getFace().equals(FACES[i])) {
                    faceCounts[i]++;
                    break;
                }
            }
        }
        return faceCounts;
    }

    // Checks for pairs
    public int findPairs(Card[] hand) {
        int pairCount = 0;
        int[] faceCounts = countFaces(hand);

        for (int i = 0; i < faceCounts.length; i++) {
            if (faceCounts[i] == 2) {
                System.out.printf("Pair of %ss\n", FACES[i]);
                pairCount++;
            }
        }
        return pairCount;
    }
    // Checks for three of a kind
    public int findThreeOfAKind(Card[] hand) {
        int tripleCount = 0;
        int[] faceCounts = countFaces(hand);

        for (int i = 0; i < faceCounts.length; i++) {
            if (faceCounts[i] == 3) {
                System.out.printf("Three %ss\n", FACES[i]);
                tripleCount++;
                break;
            }
        }
        return tripleCount;
    }
    //four of a kind
    public void findFourOfAKind(Card[] hand) {
        int[] faceCounts = countFaces(hand);

        for (int i = 0; i < FACES.length; i++) {
            if (faceCounts[i] == 4) {
                System.out.printf("Four %ss\n", FACES[i]);
            }
        }
    }
    // Checks for flush
    public void checkFlush(Card[] hand) {
        String firstSuit = hand[0].getSuit();
    
            for (int i = 1; i < hand.length; i++) {
                if (!hand[i].getSuit().equals(firstSuit)) {
                    return;
                }
            }
            System.out.printf("Flush in %s\n", firstSuit);
        }
    
        // Checks for straight
        public void checkStraight(Card[] hand) {
            int[] faceIndices = new int[5];
            int index = 0;
            int[] faceCounts = countFaces(hand);
    
            // Collect indices of face
            for (int i = 0; i < faceCounts.length; i++) {
                if (faceCounts[i] == 1) {
                    faceIndices[index++] = i;
                }
            }
            Arrays.sort(faceIndices);
            int startValue = faceIndices[0];
    
            // Ace low or Ace High straight
            if (faceIndices[0] == 3) { 
                // Check Ace-low (A,2,3,4,5) -> indices 3,4,5,6,7
                boolean isLowStraight = true;
                for (int i = 1; i < faceIndices.length; i++) {
                    if (faceIndices[i] != faceIndices[0] + i) {
                        isLowStraight = false;
                        break;
                    }
                }
                if (isLowStraight) {
                    System.out.println("Straight");
                    return;
                }
                if (faceIndices[0] == 0 && faceIndices[1] == 1 &&
                    faceIndices[2] == 2 && faceIndices[3] == 3 &&
                    faceIndices[4] == 12) {
                    System.out.println("Straight");
                    return;
                }
            } else {
                // Check regular straight
                for (int i = 1; i < faceIndices.length; i++) {
                    if (faceIndices[i] != startValue + i) {
                        return;
                    }
                }
                System.out.println("Straight");
            }
        }
        //full house
        public void checkFullHouse(int pairCount, int tripleCount) {
            if (pairCount == 1 && tripleCount == 1) {
                System.out.println("\nFull House!");
            }
        }
    
        //two pairs
        public void checkTwoPairs(int pairCount) {
            if (pairCount == 2) {
                System.out.println("\nTwo Pair!");
            }
        }
}
