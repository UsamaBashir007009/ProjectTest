package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpScreen extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private CheckBox termsNconditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        name=findViewById(R.id.et_signup_name);
        email=findViewById(R.id.et_signup_email);
        confirmPassword=findViewById(R.id.et_signup_cpassword);
        password=findViewById(R.id.et_signup_password);
        termsNconditions=findViewById(R.id.checkBox_terms);
    }


    public void call_login1(View view)
    {
        if( TextUtils.isEmpty(name.getText())){
            name.setError( "Name is required!" );
            this.show_toast("Please enter your name");
        }

        else{
        if( TextUtils.isEmpty(email.getText())) {
            email.setError( "Email is required!" );
            this.show_toast("Please enter your email address!");
        }


        else {
            String email1 = email.getText().toString().trim();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (email1.matches(emailPattern)) {

                if (TextUtils.isEmpty((password.getText()))) {
                    this.show_toast("Enter your password!");
                } else if (password.getText().length() < 8) {
                    this.show_toast("Password should be minimum 8 characters long");
                } else {

                    if(TextUtils.isEmpty(confirmPassword.getText()))
                    {
                        this.show_toast("Please confirm your password!");
                    }
                    else {
                        if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
                            this.show_toast("Password did not match!");
                        } else {
                            if (termsNconditions.isChecked()) {

                                this.show_toast("Successfully Logged In!");
                                Intent intent = new Intent(SignUpScreen.this, HomePageTabScreen.class);
                                startActivity(intent);
                                email.getText().clear();
                                name.getText().clear();
                                password.getText().clear();
                                confirmPassword.getText().clear();
                                termsNconditions.toggle();
                                name.setCursorVisible(false);
                                email.setCursorVisible(false);
                                password.setCursorVisible(false);
                                confirmPassword.setCursorVisible(false);
                            } else {
                                this.show_toast("Please agree to Terms and Conditions!");
                            }
                        }
                    }

                }
            } else {
                this.show_toast("Please enter a valid email address!");
            }
        }
        }

    }

    public void call_signin(View view)
    {
        Intent intent = new Intent(SignUpScreen.this, SignInScreen.class);
        startActivity(intent);
    }

    public void show_toast(String string)
    {
        Toast toast = Toast.makeText(SignUpScreen.this, string, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 20);
        toast.show();
    }
}
