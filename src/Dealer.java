public class Dealer
{
    private Deck cardDeck = new Deck();
    private Hand[] player;

    Dealer(int totalHands) {
        player = new Hand[totalHands];
        for (int i = 0; i < totalHands; i++) {
            player[i] = new Hand();
        }
    }

    public void proveDeck(int cardsPerLine) {
        cardDeck.displayDeck(cardsPerLine);
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
    public void layEmOut(int cardsPerLine) {
        for (int i = 0; i < player.length; i++) {
            System.out.println("\n--- Hand " + (i+1) + " ---\n");
            player[i].showYourHand(cardsPerLine);
            System.out.println("score = " + player[i].handValue());
        }
    }
}
