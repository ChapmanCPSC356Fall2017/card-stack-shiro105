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

    // Returns the face card representation if applicable
    public String getFaceCardValue()
    {
        String result = "";
        switch(cardNumber)
        {
            case 1:
                result = "A";
                break;
            case 11:
                result = "J";
                break;
            case 12:
                result = "Q";
                break;
            case 13:
                result = "K";
                break;
        }
        return result;
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
