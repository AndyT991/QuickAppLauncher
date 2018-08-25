package com.example.andy_.quickapplauncher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attempts to launch activity within our own app
        Button secondActivityButton = (Button)findViewById(R.id.secondActivityButton);

        secondActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                startIntent.putExtra("com.example.andy_.quickapplauncher.SOMETHING","Welcome to Second Activity");
                startActivity(startIntent);
            }
        });

        //Attempt to launch an activity outside our app
        Button googleButton =  findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = "https://github.com/AndyT991";
                Uri webaddress = Uri.parse(search);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoGoogle.resolveActivity(getPackageManager())!=null){
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}
