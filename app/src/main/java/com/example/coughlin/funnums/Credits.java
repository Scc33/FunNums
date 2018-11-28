package com.example.coughlin.funnums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Credits extends AppCompatActivity {
    private static final String TAG = "FunNums:Credits";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        final Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Back button clicked");
                Intent intent = new Intent(Credits.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
