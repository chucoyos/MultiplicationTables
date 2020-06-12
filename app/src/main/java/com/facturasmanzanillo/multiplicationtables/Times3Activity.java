package com.facturasmanzanillo.multiplicationtables;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Times3Activity extends AppCompatActivity {

    TextView multiplyTextView;//muestra el valor a multiplicar
    TextView resultTextView; // muestra si la respuesta es correcta
    int multiplicador;
    Button button1, button2, button3, button4, goButton;
    int locationOfCorrectAnswer;
    MediaPlayer mediaPlayer;
    ArrayList<Integer> answers = new ArrayList<>();
    LinearLayout topPanel, bottomPanel;

    public void onClickStart(View view){
        topPanel.setVisibility(View.VISIBLE);
        bottomPanel.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.GONE);
        newQuestion();
    }

    public void newQuestion(){
        Random random = new Random();
        multiplicador = random.nextInt(11);
        multiplyTextView.setText(String.valueOf(multiplicador));
        locationOfCorrectAnswer = random.nextInt(4);
        answers.clear();

        for (int i = 0; i < 4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(3 * multiplicador);
            } else {
                int wrongAnswer = random.nextInt(31);

                while (wrongAnswer == 3 * multiplicador){
                    wrongAnswer = random.nextInt(31);
                }
                answers.add(wrongAnswer);
            }

        }

        button1.setText(String.valueOf(answers.get(0)));
        button2.setText(String.valueOf(answers.get(1)));
        button3.setText(String.valueOf(answers.get(2)));
        button4.setText(String.valueOf(answers.get(3)));

    }

    public void chooseAnswer(View view){
        if (String.valueOf(locationOfCorrectAnswer).equals(view.getTag().toString())){
            resultTextView.setText(R.string.correct);
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.blop);
            mediaPlayer.start();

        } else {
            resultTextView.setText(R.string.wrong);
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fail);
            mediaPlayer.start();
        }
        newQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times3);

        multiplyTextView = findViewById(R.id.multiplyTextView);
        resultTextView = findViewById(R.id.resultTextView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        topPanel = findViewById(R.id.topPanel);
        goButton = findViewById(R.id.goButton);
        bottomPanel = findViewById(R.id.bottomPanel);
    }
}
