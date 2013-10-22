import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// The Hand Class contains methods expected of a player in a card game: receiving a card from a Dealer,
// showing the cards in a Hand, tabulating the Score, and discarding the cards in the Hand
public class Hand
{
    private List<Card> cardsInHand = new ArrayList<Card>();

    public void receiveCard(Card aCard) {
        cardsInHand.add(aCard);
    }

    public void showYourHand(int displayLines) {
        Iterator<Card> iterator = cardsInHand.iterator();
        while (iterator.hasNext()) {
            for(int i = 0; i < displayLines && iterator.hasNext(); i++) {
                Card nextCard = iterator.next();
                System.out.print(nextCard + "(" + nextCard.cardValue() + ")");
                if (iterator.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public int handValue() {
        int score = 0;
        for (Card k : cardsInHand) {
            score += k.cardValue();
        }
        return score;
    }

    public void discard() {
        cardsInHand.clear();
    }
}
