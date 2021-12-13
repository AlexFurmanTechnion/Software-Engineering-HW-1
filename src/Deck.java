import java.util.Objects;
import java.util.Random;

public class Deck {

    /* We create an empty deck of 52 Card objects */
    private static final int numberOfCards = 52;
    private static final Card[] deck = new Card[numberOfCards];



    /* We start by generating an ORDERED deck of cards */
    public void generateDeck(boolean Verbose){

        /* Initialise helper variable that helps keeps track of current card in deck during iteration*/
        int count = -1;

        /* Check that the Boolean parameter is TRUE before adding cards (If FALSE - empty deck)*/
        if(Verbose){

            /* Iterate through each suit*/
            for(Suit i : Suit.values()){

                /* Iterate through all possible card values (1-13) */
                for(int j = 1; j <= 13; j++){

                    /* Assign new Card object to the deck*/
                    deck[count + j] = new Card(i, j);
                }
                /* Adjust value of count to correctly add to the right index in the deck*/
                count = count + 13;
            }
        }
    }



    /*Method to find the current number of cards in the deck*/
    public int getNumberOfCards(){

        /*Initialise helper variable that will keep track of number of cards in the deck*/
        int count = 0;

        /*find the number of non-empty Card objects in the deck*/
        for(int i = 0; i < numberOfCards; i++){

            /*If the current index has a card, increase count*/
            if(!Objects.isNull(deck[i])){
                count++;
            }

            /*If the current index is null, we are done counting*/
            else{
                break;
            }
        }
        return count;
    }

    /*Method to find the index of the top card*/
    public int getTopIndex(){
        return getNumberOfCards() - 1;
    }

    public Card getCard(int index){
        return deck[index];
    }



    /* Method to add Card to top of deck:*/
    /* We define top of the deck as the first instance where there */
    /* has not been a card placed in the deck yet*/
    public void addCard(Card card){

        int firstEmptyIndex = getTopIndex() + 1;
        deck[firstEmptyIndex] = card;
    }



    public Card removeTopCard(){

        /*Define a card that points to the top card in heap*/
        Card topCard = deck[getTopIndex()];

        /*nullify the current index in the deck, since there is now no initialized card there*/
        deck[getTopIndex()] = null;

        /*Finally, return the top card*/
        return topCard;
    }



    /*Method to check if deck is empty*/
    public boolean isEmpty(){

        /*Return a boolean representing if the deck is empty (true) or not (false)*/
        /*This will evaluate to true if getNumberOfCards == 0 i.e. the number of cards in the deck == 0*/
        return (getNumberOfCards() == 0);
    }



    /*Method which randomly shuffles the deck*/
    public void shuffle(){

        /*Find current number of cards in deck*/
        int count = getNumberOfCards();

        /* Now implement shuffling algorithm: Iterate through the deck 'count' times, and randomly*/
        /* replace the current card of each iteration with another random card from the deck*/
        for(int i = 0; i < count; i++){

            /*Create a random int between 0 up to 'count', to help find which random card we will use*/
            int randomIndex;
            Random r = new Random();
            randomIndex = r.nextInt(count);

            /*Create a Card object that points to the current Card in Heap Memory*/
            Card helperCard = deck[i];

            /*Make the current index in the deck point to the random Card in Heap Memory*/
            deck[i] = deck[randomIndex];

            /*Make the random index in the deck point to the current Card in Heap Memory*/
            deck[randomIndex] = helperCard;

        }
    }
}
