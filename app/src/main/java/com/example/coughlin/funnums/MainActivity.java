package com.example.coughlin.funnums;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "FunNums:Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startTrivia = findViewById(R.id.trivia);
        startTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start trivia button clicked");
                Intent intent = new Intent(MainActivity.this, triviaActivity.class);
                intent.putExtra("TYPE","Trivia");
                startActivity(intent);
            }
        });

        final Button startYear = findViewById(R.id.year);
        startYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start year button clicked");
                Intent intent = new Intent(MainActivity.this, triviaActivity.class);
                intent.putExtra("TYPE","Year");
                startActivity(intent);
            }
        });

        final Button startDate = findViewById(R.id.date);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start date button clicked");
                Intent intent = new Intent(MainActivity.this, triviaActivity.class);
                intent.putExtra("TYPE","Date");
                startActivity(intent);
            }
        });

        final Button startMath = findViewById(R.id.math);
        startMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start math button clicked");
                Intent intent = new Intent(MainActivity.this, triviaActivity.class);
                intent.putExtra("TYPE","Math");
                startActivity(intent);
            }
        });

        final Button startCredit = findViewById(R.id.credit);
        startCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start credit button clicked");
                Intent intent = new Intent(MainActivity.this, Credits.class);
                startActivity(intent);
            }
        });
    }
}
