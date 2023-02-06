package com.example.duongchikhang_se161516_lab22;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);

        tvAlreadyAccount.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
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

        if (TextUtils.isEmpty(etConfirmPassword.getText().toString())){
            return false;
        }

        if (!TextUtils.equals(etPassword.getText().toString()
        , etConfirmPassword.getText().toString())){
            Toast.makeText(this, "Password are not match", Toast.LENGTH_SHORT).show();
        return false;
        }
//        Valid
        return false;
    }

    private void signUp(){
        if (!checkInput()){
            return;
        }
    }

    private void signInForm(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignUp:
                signUp();
                break;
            case R.id.tvAlreadyAccount:
                signInForm();
                break;
        }
    }
}
