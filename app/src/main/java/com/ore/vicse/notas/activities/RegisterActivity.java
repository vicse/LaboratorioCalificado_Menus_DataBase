package com.ore.vicse.notas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ore.vicse.notas.R;
import com.ore.vicse.notas.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstnameInput,fullnameInput,emailInput,passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstnameInput= (EditText) findViewById(R.id.firstname_input);
        fullnameInput= (EditText) findViewById(R.id.fullname_input);
        emailInput= (EditText) findViewById(R.id.email_input);
        passwordInput= (EditText) findViewById(R.id.password_input);

    }

    public void callRegister(View view){
        String firstname = firstnameInput.getText().toString();
        String fullname= fullnameInput.getText().toString();
        String email= emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(firstname.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Debes completar los campos",Toast.LENGTH_LONG).show();
            return;
        }

        UserRepository.create(firstname,fullname,email,password);

        finish();
    }
}
