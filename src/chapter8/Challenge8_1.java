package chapter8;

/**
 * Created by asus on 8/26/17.
 * Design data structures for a generic deck of cards. Explain how you would subclass
 * the data structures to implement blackjack.
 *
 * Let assume generic deck means 52 card set.
 */
import sun.rmi.server.InactiveGroupException;

import java.util.List;
import java.util.ArrayList;

enum Suit{
    Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;

    Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static Suit getSuitFromValue(int value){
        switch (value){
            case 0: return Club;
            case 1: return Diamond;
            case 2: return Heart;
            case 3: return Spade;
        }
        return null;
    }
}

class Deck <T extends Card>{
    private List<T> cards; // all cards
    private int dealtIndex = 0; // the first undealt card

    public void shuffle(){}
    public int remainingCards(){
        return cards.size() - dealtIndex;
    }
    public T[] dealHand(int number){
        return null;
    }
    public T dealCard(){
        return null;
    }
}

abstract class Card{
    private boolean available = true;
    protected int faceValue;  // a number 2-10, 11-Jack, 12-Queen, 13-King, 1-Ace
    protected Suit suit;

    public Card(int c, Suit s){
        faceValue = c;
        suit = s;
    }

    public abstract int value();
    public Suit suit(){return suit;}


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Hand <T extends Card>{
    protected List<T> cards = new ArrayList();

    public int score(){
        int score = 0;
        for (T card : cards){
            score += card.value();
        }
        return score;
    }

    public void addCard(T card){
        cards.add(card);
    }
}

class BlackJackCard extends Card{

    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    @Override
    public int value() {
        if (isAce()) return 1;
        else if (isFaceCard()) return 10;
        else return faceValue;
    }

    public boolean isAce(){
        return faceValue == 1;
    }

    public int minValue(){
        if (isAce()) return 1;
        return value();
    }

    public int maxValue(){
        if (isAce()) return 11;
        return value();
    }

    public boolean isFaceCard(){
        return faceValue >= 11 && faceValue <= 13;
    }
}

class BlackJackHand extends Hand<BlackJackCard>{
    // Return highest possible score < 21 or lowest score > 21

    @Override
    public int score() {
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores){
            if (score > 21 && score < minOver) minOver = score;
            else if (score <= 21 && score > maxUnder) maxUnder = score;
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    // Return list of possible hand scores, each Ace can be both 1 and 11.
    private List<Integer> possibleScores(){
        return null;
    }

    public boolean busted() { return score() > 21; }
    public boolean is21(){
        return score() == 21;
    }
    public boolean isBlackJack(){
        return false; // todo
    }
}

public class Challenge8_1 {

}
