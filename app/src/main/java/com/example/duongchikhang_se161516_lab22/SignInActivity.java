package com.example.duongchikhang_se161516_lab22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

//    Views
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvNotAccountYet;
    private Button btnSignIn;

//    Notify
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

//    Reference from layout
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvNotAccountYet = findViewById(R.id.tvNotAccountYet);
        btnSignIn = findViewById(R.id.btnSignIn);

//    Register event
        tvNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private boolean checkInput(){
//        Username
        if (TextUtils.isEmpty(etUsername.getText().toString())){
            return false;
        }

//        Password
        if (TextUtils.isEmpty(etPassword.getText().toString())){
            return false;
        }

//        Valid
        return false;
    }

    private void signIn() {
//        Invalid
        if(!checkInput()){
            return;
        }
        //    Start MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
//        Close current activity
    }

    private void signUpForm(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            Sign in action
            case R.id.btnSignIn:
                signIn();
                break;
            case R.id.tvNotAccountYet:
                signUpForm();
                break;
        }
    }
}