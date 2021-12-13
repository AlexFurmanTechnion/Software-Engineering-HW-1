import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rnd;

    public static void main(String[] args) throws FileNotFoundException {

        /*Just testing to make sure the Card and Deck classes are working correctly*/
        Deck deck1 = new Deck();
        deck1.generateDeck(true);
        deck1.shuffle();
        System.out.println(deck1.getNumberOfCards());
        System.out.println(deck1.getTopIndex());
        System.out.println("We are removing: " + deck1.removeTopCard());
        for(int i = 0; i < 52; i++){
            System.out.println(deck1.getCard(i));
        }
        System.out.println(deck1.getNumberOfCards());
        System.out.println(deck1.getTopIndex());
        for(int i = 0; i < 51; i++){
            System.out.println("We are removing: " + deck1.removeTopCard());
        }
        for(int i = 0; i < 52; i++){
            System.out.println(deck1.getCard(i));
        }
        System.out.println("The statement that the deck is empty is... " + deck1.isEmpty());
        Card myCard = new Card(Suit.Clubs, 12);
        System.out.println("We will add the following card:" + myCard);
        deck1.addCard(myCard);
        for(int i = 0; i < 52; i++){
            System.out.println(deck1.getCard(i));
        }




        /*
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        int numberOfGames = scanner.nextInt();

        for (int i = 0; i < numberOfGames; i++) {
            int seed = scanner.nextInt();
            rnd = new Random(seed);
            scanner.nextLine();
            String player1 = scanner.nextLine();
            String player2 = scanner.nextLine();
            WarGame game = new WarGame(player1, player2);
            String winner = game.start();
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println(winner + " won the game!\n\n");
        }
         */
    }
}
