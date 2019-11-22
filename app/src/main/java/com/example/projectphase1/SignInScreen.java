package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInScreen extends AppCompatActivity {

    private EditText email;
    private EditText password;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            this.show_toast("Click BACK again to exit!");

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
        setContentView(R.layout.activity_sign_in_screen);

        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);

    }

    public void call_signup(View view)
    {
        Intent intent = new Intent(SignInScreen.this, SignUpScreen.class);
        startActivity(intent);
    }

    public void call_login(View view)
    {

        if( TextUtils.isEmpty(email.getText())) {
            email.setError( "Email is required!" );
            this.show_toast("Email is required!");
        }


        else {
            String email1 = email.getText().toString().trim();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (email1.matches(emailPattern)) {

                if(TextUtils.isEmpty((password.getText()))) {
                   this.show_toast("Enter your password!");
                }

                else if(password.getText().length()<8) {
                    this.show_toast("Password should be minimum 8 characters long");
                }

                else {
                    Intent intent = new Intent(SignInScreen.this, HomePageTabScreen.class);
                    startActivity(intent);
                    email.getText().clear();
                    password.getText().clear();
                    email.setSelection(0);
                }
            }

            else {
                this.show_toast("Invalid email address");
            }
        }

    }

    public void show_toast(String string)
    {
        Toast toast = Toast.makeText(SignInScreen.this, string, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 20);
        toast.show();
    }

}
