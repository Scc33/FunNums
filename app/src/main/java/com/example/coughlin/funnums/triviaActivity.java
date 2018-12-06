package com.example.coughlin.funnums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class triviaActivity extends AppCompatActivity {
    private static final String TAG = "FunNums:Trivia";

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        Intent intent = getIntent();

        final String type = intent.getStringExtra("TYPE");

        final TextView title = (TextView) findViewById(R.id.type);
        title.setText(type);

        requestQueue = Volley.newRequestQueue(this);

        final EditText input = (EditText) findViewById(R.id.editNumber);

        final Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Enter button clicked");
                title.setText(type + " " + input.getText());
                System.out.println(input.getText());
                String url = "http://numbersapi.com/" + input.getText() + "/" + type.toLowerCase() + "?json";
                startAPICall(url);
            }
        });
        final Button random = findViewById(R.id.random);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Random button clicked");
                title.setText(type);
                System.out.println(input.getText());
                String url = "http://numbersapi.com/random/" + type.toLowerCase() + "?json";
                startAPICall(url);
            }
        });
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

    void startAPICall(String x) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    x,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            try {
                                Log.d(TAG, response.toString());
                                final TextView factView = (TextView) findViewById(R.id.factView);
                                factView.setText(response.getString("text"));
                            } catch (JSONException e) {
                                //some exception handler code.
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
