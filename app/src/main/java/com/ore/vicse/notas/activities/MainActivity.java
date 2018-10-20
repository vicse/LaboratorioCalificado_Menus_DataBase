package com.ore.vicse.notas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ore.vicse.notas.R;
import com.ore.vicse.notas.repositories.UserRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText firstname,contraseña;

    private CardView btnRegister,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = (CardView) findViewById(R.id.btn_register);
        btnLogin= (CardView) findViewById(R.id.btn_login);
        firstname= (EditText) findViewById(R.id.txt_name);
        contraseña= (EditText) findViewById(R.id.txt_password);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btn_register:
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                String n = firstname.getText().toString();
                String c = contraseña.getText().toString();
                if(UserRepository.InicioDeSesion(n,c)) {

                    Intent intent1 = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
