public class Assignment2 {
    // these can't be final, because main would not be able to set them if they were
    private static int N_GAMES;
    private static int N_HANDS;
    private static int CARDS_PER_HAND;
    private static int CARDS_PER_LINE;
    private static boolean SHUFFLE;

    public static void main(String args[]) {
        // remember to have this print your own name instead of I. Forgot
        // Alternately, just let it print I. Forgot. No one will think you are a fool.
        System.out.printf("CS261 - Assignment 2 - Randall Sewell%n%n");

        // get command line arguments
        if (args.length != 5) {
            System.out.println("requires 5 arguments: nGames, nHands, cardsPerHand, cardsPerLine, shuffle");
            return;
        }
        try {
            N_GAMES = Integer.parseInt(args[0]);
            N_HANDS = Integer.parseInt(args[1]);
            CARDS_PER_HAND = Integer.parseInt(args[2]);
            CARDS_PER_LINE = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.out.printf("bad numeric argument %s%n", e.getMessage());
            return;
        }
        SHUFFLE = new Boolean(args[4]);

        System.out.printf("games: %d, hands: %d, cards per hand: %d,%ncards per line: %d, shuffle: %b%n%n",
                N_GAMES, N_HANDS, CARDS_PER_HAND, CARDS_PER_LINE, SHUFFLE);

        // add your code here
        Dealer FDR = new Dealer(N_HANDS, CARDS_PER_LINE);
        FDR.proveDeck();
        for (int i = 0; i < N_GAMES; i++) {
            System.out.println("\n=== Game " + (i + 1) + " ===");
            FDR.newGame();
            FDR.dealHands(N_HANDS, CARDS_PER_HAND);
            FDR.layEmOut();
        }
        System.out.println("\n=== Games Complete ===");
    }
}
