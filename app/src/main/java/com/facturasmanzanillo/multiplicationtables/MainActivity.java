package com.facturasmanzanillo.multiplicationtables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;

    public void onClick(View view){
        switch (view.getId()) {

            case R.id.button1:
                Intent intent1 = new Intent(view.getContext(), Times1Activity.class);
                view.getContext().startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent = new Intent(view.getContext(), Times2Activity.class);
                view.getContext().startActivity(intent);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(view.getContext(), Times3Activity.class);
                view.getContext().startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(view.getContext(), Times4Activity.class);
                view.getContext().startActivity(intent4);
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
    }
}
