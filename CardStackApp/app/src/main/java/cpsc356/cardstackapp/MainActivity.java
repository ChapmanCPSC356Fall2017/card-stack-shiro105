package cpsc356.cardstackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Stack<Card> cardStack = new Stack<>();      // Holds all of the cards currently in play

    private Suit[] suitList = {Suit.Club, Suit.Diamond, Suit.Heart, Suit.Spade};        // An array of all of the suits

    private int totalCards = 52;                        // How many cards will there be?
    private int suitLimit = 13;                         // How many cards will there be per suit?

    private TextView top_valueDisplay;
    private TextView bottom_valueDisplay;
    private ImageView top_iconDisplay;
    private ImageView bottom_iconDisplay;
    private ImageView center_iconDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_valueDisplay = (TextView) findViewById(R.id.top_value);
        bottom_valueDisplay = (TextView) findViewById(R.id.bottom_value);
        top_iconDisplay = (ImageView) findViewById(R.id.top_icon);
        center_iconDisplay = (ImageView) findViewById(R.id.center_icon);
        bottom_iconDisplay = (ImageView) findViewById(R.id.bottom_icon);

        // Upon creation, the cardStack will have 52 cards in it
        int cardCount = 1;                      // Keeps track of the current iteration on the amount of cards per suit
        int currentSuitIndex = 0;               // Used to iterate through the suits array
        for(int i = 0; i < totalCards; ++i)
        {
            if(cardCount > suitLimit)
            {
                cardCount = 1;
                currentSuitIndex++;
            }
            else
            {
                cardStack.push(new Card(cardCount, suitList[currentSuitIndex]));
                cardCount++;
            }
        }

        // Randomly reorders the cardStack
        Collections.shuffle(cardStack);

        // We then pop out the first Card
        displayCard();
    }

    // Displays a card to the screen
    private void displayCard()
    {
        Card currentCard = cardStack.pop();
        String cardValue = currentCard.getFaceCardValue();
        Suit cardSuit = currentCard.getSuitType();
        int cardImageResource = 0;

        if(currentCard.getFaceCardValue().isEmpty())
        {
            cardValue = String.valueOf(currentCard.getCardNumber());
        }

        if(cardSuit == Suit.Club)
        {
            cardImageResource = R.drawable.club;
        }
        else if(cardSuit == Suit.Diamond)
        {
            cardImageResource = R.drawable.diamond;
        }
        else if(cardSuit == Suit.Heart)
        {
            cardImageResource = R.drawable.heart;
        }
        else if(cardSuit == Suit.Spade)
        {
            cardImageResource = R.drawable.spade;
        }

        top_valueDisplay.setText(cardValue);
        bottom_valueDisplay.setText(cardValue);
        top_iconDisplay.setImageResource(cardImageResource);
        center_iconDisplay.setImageResource(cardImageResource);
        bottom_iconDisplay.setImageResource(cardImageResource);
    }
}
