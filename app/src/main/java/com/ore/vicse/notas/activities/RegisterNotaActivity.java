package com.ore.vicse.notas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ore.vicse.notas.R;
import com.ore.vicse.notas.repositories.NotaRepository;

public class RegisterNotaActivity extends AppCompatActivity {

    private EditText tittleInput,contenidoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nota);

        tittleInput= (EditText) findViewById(R.id.tittle_input);
        contenidoInput= (EditText) findViewById(R.id.contenido_input);


    }

    public void callRegisterNota(View view){
        String tittle= tittleInput.getText().toString();
        String contenido= contenidoInput.getText().toString();

        if(tittle.isEmpty() || contenido.isEmpty()){
            Toast.makeText(this,"Relleno todos los campos",Toast.LENGTH_LONG).show();
            return;
        }

        NotaRepository.create(tittle,contenido);

        finish();

    }
}
