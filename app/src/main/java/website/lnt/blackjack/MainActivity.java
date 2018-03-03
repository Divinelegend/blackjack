package website.lnt.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Blackjack game;
    private Player currentPlayer;

    public void numBtnOnClick(View v) {

        switch (v.getId()) {
            case R.id.bntStay:
            case R.id.bntHit:
            case R.id.bntSplit:
            case R.id.bntBet:
            case R.id.bntStart:
            case R.id.bntInsure:
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView outputdealerhand = findViewById(R.id.txtDealerHand);
        TextView outputplayerhand = findViewById(R.id.txtPlayerHand);
        TextView outputpot = findViewById(R.id.txtPot);
        TextView outputuserinstruction = findViewById(R.id.txtUserInstruction);
        TextView outputyourwallet = findViewById(R.id.txtYourWallet);
        TextView outputdealerpoint = findViewById(R.id.txtDealerPoint);
        TextView outputyourpoint = findViewById(R.id.txtYourPoint);

        currentPlayer = new Player("Kaiju", false, 100);
        game = new Blackjack(1, 1);
        try {
            game.addPlayer(currentPlayer);
        } catch (BlackjackException e) {
            Log.e("MainActivity", e.getMessage());
        }
    }
}
