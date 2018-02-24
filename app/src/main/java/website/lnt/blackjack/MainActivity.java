package website.lnt.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Blackjack game;
    private Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentPlayer = new Player("Kaiju", false, 100);
        game = new Blackjack(1, 1);
        try {
            game.addPlayer(currentPlayer);
        } catch (BlackjackException e) {
            Log.e("MainActivity", e.getMessage());
        }
    }
}
