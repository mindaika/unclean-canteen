import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

// The Deck class contains methods for returning a card from a Deck, creating a new Deck,
// and displaying the items in the Deck
class Deck
{
    private static final List<Card> protoDeck = new ArrayList<Card>();

    // initialize prototype deck
    // I'm guessing this is a static constructor, but it's unlabeled and I didn't
    // make it, so I'm not sure
    static {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
    }

    // Creates a new deck
    private static void newDeck() {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
    }

    /* Not used at the moment
    public int deckSize() {
        return protoDeck.size();
    }
    */

    // Get the next card
    public Card getCard() {
        Card out;
        if (protoDeck.isEmpty()) {
            newDeck();
        }
        out = protoDeck.get(0);
        protoDeck.remove(0);
        return out;
    }

    // Show the cards in the deck
    public void displayDeck(int cardsPerLine) {
        Iterator<Card> iterator = protoDeck.iterator();
        System.out.println("deck:");

        while (iterator.hasNext()) {
            for(int i = 0; i < cardsPerLine && iterator.hasNext(); i++) {
                Card nextCard = iterator.next();
                System.out.print(nextCard + "(" + nextCard.cardValue() + ")");
                if (iterator.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
