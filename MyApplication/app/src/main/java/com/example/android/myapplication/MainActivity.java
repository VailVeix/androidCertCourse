package com.example.android.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText websiteEditText;
    private EditText locationEditText;
    private EditText shareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        websiteEditText = findViewById(R.id.website_edittext);
        locationEditText = findViewById(R.id.location_edittext);
        shareEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view){
        String URL = websiteEditText.getText().toString();
        Uri webpage = Uri.parse(URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't  hadnle this!");
        }
    }

    public void openLocation(View view){
        String URL = locationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't  hadnle this!");
        }
    }

    public void shareText(View view) {
        String txt = shareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();    
    }
}
