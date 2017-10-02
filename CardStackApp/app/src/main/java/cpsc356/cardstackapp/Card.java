package cpsc356.cardstackapp;

/**
 * Created by matthewshiroma on 10/1/17.
 */

public class Card {

    private int cardNumber;
    private Suit suitType;

    public Card(int cardNo, Suit suit)
    {
        cardNumber = cardNo;
        suitType = suit;
    }

    public int getCardNumber()
    {
        return cardNumber;
    }

    public Suit getSuitType()
    {
        return suitType;
    }


    public boolean compareCards(Card other)
    {
        if(cardNumber == other.getCardNumber() && compareSuits(other.getSuitType()) == true)
        {
            return true;
        }
        return false;
    }

    public boolean compareSuits(Suit other)
    {
        if(suitType == Suit.Club && other == Suit.Club)
        {
            return true;
        }
        else if(suitType == Suit.Diamond && other == Suit.Diamond)
        {
            return true;
        }
        else if(suitType == Suit.Heart && other == Suit.Heart)
        {
            return true;
        }
        else if(suitType == Suit.Spade && other == Suit.Spade)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
