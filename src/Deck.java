import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Deck
{
    private static final List<Card> protoDeck = new ArrayList<Card>();

    // initialize prototype deck
    static {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
    }

    public boolean isEmpty() {
        return protoDeck.isEmpty();
    }

    public int deckSize() {
        return protoDeck.size();
    }

    public Card getCard(int cardNumber) {
        return protoDeck.get(cardNumber);
    }

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
