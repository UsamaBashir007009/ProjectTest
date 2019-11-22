package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class RegistrationScreen extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            this.show_toast("press BACK again to exit!");

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
    }

    public void call_r_signup(View view)
    {
        Intent intent = new Intent(RegistrationScreen.this, SignUpScreen.class);
        startActivity(intent);
    }

    public void call_r_signin(View view)
    {
        Intent intent = new Intent(RegistrationScreen.this, SignInScreen.class);
        startActivity(intent);
    }

    public void call_google(View view)
    {
        Intent intent = new Intent(RegistrationScreen.this, HomePageTabScreen.class);
        startActivity(intent);
    }


    public void show_toast(String string)
    {
        Toast toast = Toast.makeText(RegistrationScreen.this, string, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 20);
        toast.show();
    }
}
