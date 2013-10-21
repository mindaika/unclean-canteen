public class Dealer
{
    private Deck cardDeck = new Deck();
    Hand[] player;

    public void proveDeck(int cardsPerLine) {
        cardDeck.displayDeck(cardsPerLine);
    }

    // Starts a newGame
    public void newGame(int totalHands) {
        // Create an array of hands
        player = new Hand[totalHands];
        for (int i = 0; i < totalHands; i++) {
            player[i] = new Hand();
        }
    }

    // Deals the next card in the Deck to each player in order
    public void dealHands(int totalPlayers, int cardsPerPlayer) {
        for(int j = 0; j < cardsPerPlayer; j++) {
            for (int i = 0; i < totalPlayers; i++) {
                player[i].receiveCard(cardDeck.getCard(i+(j*totalPlayers)));
            }
        }

       System.out.print("Hand: ");
       player[0].showYourHand(3);
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
