package com.agiotagemltda.jokenpoker;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectingStone(View view){
        checkingWinner("stone");
    }
    public void selectingPaper(View view){
        checkingWinner("paper");
    }
    public void selectingScissors(View view){
        checkingWinner("scissors");
    }
    public void checkingWinner(String playerChoice){
        String choiceApp = choiceApp();
        TextView resultText = findViewById(R.id.result_text);
        Map<String, String> rules = new HashMap<>();
        rules.put("stone", "scissors");
        rules.put("scissors", "paper");
        rules.put("paper", "stone");

        if(playerChoice.equals(choiceApp)){
            resultText.setText("Empate");
        }
        else if(rules.get(playerChoice).equals(choiceApp)){
            resultText.setText("Você VENCEU!");
        }
        else{
            resultText.setText("Você PERDEU!");
        }
    }
    public String choiceApp(){
        int randomNumber = new Random().nextInt(3);
        String[] choices = {
                "stone",
                "paper",
                "scissors",
        };
        String choiceApp = choices[randomNumber];
        ImageView imageDefault = findViewById(R.id.image_default);
        switch (choiceApp){
            case "stone":
                imageDefault.setImageResource(R.drawable.stone);
                break;
            case "paper":
                imageDefault.setImageResource(R.drawable.paper);
                break;
            case "scissors":
                imageDefault.setImageResource(R.drawable.scissors);
                break;
            default:
                imageDefault.setImageResource(R.drawable.image_default);
        }

        return choiceApp;
    }
}