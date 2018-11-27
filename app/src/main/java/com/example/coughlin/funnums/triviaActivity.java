package com.example.coughlin.funnums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class triviaActivity extends AppCompatActivity {
    private static final String TAG = "FunNums:Trivia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        final Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Back button clicked");
                Intent intent = new Intent(triviaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
