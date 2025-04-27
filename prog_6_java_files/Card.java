public class Card {
    private final String suit;
    private final String face;

    public Card(String faceCard, String suitCard) {
        face = faceCard;
        suit = suitCard;
    }
    public String getSuit() {
        return suit;
    }
    public String getFace() {
        return face;
    }
    public String toString() {
        return face + " of " + suit;
    }
}