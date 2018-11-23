package com.example.android.dialogforalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view){
        AlertDialog.Builder myAlert = new AlertDialog.Builder(MainActivity.this);

        myAlert.setTitle(R.string.alert_text);
        myAlert.setMessage(R.string.click_text);

        myAlert.setPositiveButton(R.string.ok_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getString(R.string.press_ok_text), Toast.LENGTH_SHORT).show();
            }
        });

        myAlert.setNegativeButton(R.string.cancel_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getString(R.string.press_cancel_text), Toast.LENGTH_SHORT).show();
            }
        });

        myAlert.show();
    }
}
