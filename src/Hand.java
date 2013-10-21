import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand
{
    private List<Card> myHand = new ArrayList<Card>();

    public void receiveCard(Card aCard) {
        myHand.add(aCard);
    }

    public void showYourHand(int displayLines) {
        Iterator<Card> iterator = myHand.iterator();
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
        for (Card k : myHand) {
            score += k.cardValue();
        }
        return score;
    }
}
