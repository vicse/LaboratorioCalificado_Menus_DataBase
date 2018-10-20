package com.ore.vicse.notas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ore.vicse.notas.R;
import com.ore.vicse.notas.adapters.NotaAdapter;
import com.ore.vicse.notas.models.Nota;
import com.ore.vicse.notas.repositories.NotaRepository;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = HomeActivity.class.getSimpleName();

    public static final int REGISTER_FROM_REQUEST = 100;

    public RecyclerView notasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        notasList= (RecyclerView) findViewById(R.id.notas_list);
        notasList.setLayoutManager(new LinearLayoutManager(this));

        List<Nota> notas= NotaRepository.list();
        notasList.setAdapter(new NotaAdapter(notas));

    }

    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterNotaActivity.class), REGISTER_FROM_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        NotaAdapter adapter= (NotaAdapter)notasList.getAdapter();

        List<Nota> notas = NotaRepository.list();
        adapter.setNotas(notas);
        adapter.notifyDataSetChanged();
    }



}
