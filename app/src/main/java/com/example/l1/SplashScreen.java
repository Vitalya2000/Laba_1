package com.example.l1;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;


public class SplashScreen extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);


        Thread splash_time = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                }
                catch (InterruptedException e) {
                    e.printStackTrace(); }
                finally {
                    finish();
                }
            }
        };
        splash_time.start();
    }
}
