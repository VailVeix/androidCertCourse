package com.example.android.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "main activity tag";
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    private static final int TEXT_REQUEST = 1;
    private EditText editText;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        mReplyHeadTextView = findViewById(R.id.text_header);
        mReplyTextView = findViewById(R.id.text_message);
    }

    public void sendMsg(View view){
        Log.d(LOG_TAG, "button clicked");

        Intent intent = new Intent(this, secondActivity.class);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(secondActivity.EXTRA_MESSAGE);
                mReplyTextView.setText(reply);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
