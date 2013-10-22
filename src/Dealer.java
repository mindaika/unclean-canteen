// The Dealer class contains methods expected of a dealer: displaying a Deck of Cards, starting a new game,
// dealing out cards, and requesting players show their cards
public class Dealer
{
    private Deck cardDeck = new Deck();
    private Hand[] player;
    private int cardsToShow;

    Dealer(int totalHands, int cardsPerLine) {
        player = new Hand[totalHands];
        for (int i = 0; i < totalHands; i++) {
            player[i] = new Hand();
        }
        if (cardsPerLine < 1) {
            throw new IllegalArgumentException("cards per line must be greater than 0");
        }
        cardsToShow = cardsPerLine;
    }

    public void proveDeck() {
        cardDeck.displayDeck(cardsToShow);
    }

    // Starts a new Game
    public void newGame() {
        // Create an array of hands
        for (Hand i : player) {
            i.discard();
        }
    }

    // Deals the next card in the Deck to each player in order
    public void dealHands(int totalPlayers, int cardsPerPlayer) {
        for(int j = 0; j < cardsPerPlayer; j++) {
            for (int i = 0; i < totalPlayers; i++) {
                player[i].receiveCard(cardDeck.getCard());
            }
        }
    }

    // Shows the Score
    public void layEmOut() {
        for (int i = 0; i < player.length; i++) {
            System.out.println("\n--- Hand " + (i+1) + " ---\n");
            player[i].showYourHand(cardsToShow);
            System.out.println("score = " + player[i].handValue());
        }
    }
}
