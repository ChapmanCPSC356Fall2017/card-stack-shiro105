package cpsc356.cardstackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public Stack<Card> cardStack = new Stack<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Upon creation, the cardStack will have 52 random cards in it
    }
}
