import java.util.Random;
import java.util.Objects;

public class Card {

    /* Declare the field variables of the card*/
    private final Suit suit;
    private final int value;



    /* Constructor for a card object*/
    public Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
    }



    /* Method to retrieve card value */
    public int getValue(){
        return value;
    }



    /* Public method to retrieve suit */
    public Suit getSuit(){
        return suit;
    }



    /* Method to compare between 2 cards which has a higher value*/
    public int compare(Card other){

        /* We use Integer.compare, which returns -1 if value<other, +1 if value>other, 0 if value==other*/
        return Integer.compare(this.value, other.value);
    }



    /* Method to return the card's info as a string */
    public String toString(){

        /* make variables, so we can use the symbols of the suits */
        char spade ='\u2660';
        char diamond ='\u2666';
        char club ='\u2663';
        char heart ='\u2665';

        /* helper variables for value and suit */
        String cardValue = "";
        char cardSuit = ' ';

        /* assign char to cardSuit */
        switch(suit){
            case Spades:
                cardSuit = spade;
                break;

            case Diamonds:
                cardSuit = diamond;
                break;

            case Clubs:
                cardSuit = club;
                break;

            case Hearts:
                cardSuit = heart;
                break;
        }

        /* assign char to cardValue, and check cases for picture-cards */
        switch(value){
            case(1):
                cardValue = cardValue + "Ace";
                break;

            case(11):
                cardValue = cardValue + "Jack";
                break;

            case(12):
                cardValue = cardValue + "Queen";
                break;

            case(13):
                cardValue = cardValue + "King";
                break;

            default:
                cardValue = cardValue + value;
        }

        /* Finally return the String representation of the card*/
        return(cardValue + " of " + cardSuit);

    }

}
