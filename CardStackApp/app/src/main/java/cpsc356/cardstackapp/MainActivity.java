package cpsc356.cardstackapp;

import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private LinearLayout main_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // We prevent the user from rotating the app
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        top_valueDisplay = (TextView) findViewById(R.id.top_value);
        bottom_valueDisplay = (TextView) findViewById(R.id.bottom_value);
        top_iconDisplay = (ImageView) findViewById(R.id.top_icon);
        center_iconDisplay = (ImageView) findViewById(R.id.center_icon);
        bottom_iconDisplay = (ImageView) findViewById(R.id.bottom_icon);
        main_Layout = (LinearLayout) findViewById(R.id.activity_main);

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

        // Whenever the user clicks anywhere on the screen, the next card will appear
        main_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCard();
            }
        });
    }

    // Displays a card to the screen
    private void displayCard()
    {
        // If the card stack is empty, we exit the activity
        if(!cardStack.isEmpty())
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
                top_valueDisplay.setTextColor(Color.BLACK);
                bottom_valueDisplay.setTextColor(Color.BLACK);
            }
            else if(cardSuit == Suit.Diamond)
            {
                cardImageResource = R.drawable.diamond;
                top_valueDisplay.setTextColor(Color.RED);
                bottom_valueDisplay.setTextColor(Color.RED);
            }
            else if(cardSuit == Suit.Heart)
            {
                cardImageResource = R.drawable.heart;
                top_valueDisplay.setTextColor(Color.RED);
                bottom_valueDisplay.setTextColor(Color.RED);
            }
            else if(cardSuit == Suit.Spade)
            {
                cardImageResource = R.drawable.spade;
                top_valueDisplay.setTextColor(Color.BLACK);
                bottom_valueDisplay.setTextColor(Color.BLACK);
            }

            top_valueDisplay.setText(cardValue);
            bottom_valueDisplay.setText(cardValue);
            top_iconDisplay.setImageResource(cardImageResource);
            center_iconDisplay.setImageResource(cardImageResource);
            bottom_iconDisplay.setImageResource(cardImageResource);
        }
        else
        {
            finish();
        }
    }
}
