package com.example.android.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    private static final String LOG_TAG = "main activity tag";
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.REPLY";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

        editText = (EditText)findViewById(R.id.editText);
    }

    public void Reply(View view) {
        Log.d(LOG_TAG, "button clicked");

        Intent intent = new Intent(this, MainActivity.class);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        setResult(RESULT_OK, intent);
        finish();
    }
}
