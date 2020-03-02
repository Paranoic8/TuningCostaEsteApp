package com.example.tuningcostaesteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisenoActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewDiseno)
    RecyclerView recyclerviewDiseno;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private DisenoAdapter adapter;
    private List<Diseno> disenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseno);

        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nuevo");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisenoActivity.this, AddDisenoActivity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        disenos = new ArrayList<>();

        disenos.add(new Diseno(1, "Sticker de Sangre",1, R.drawable.poalrizados,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(2, "Sticker Red Bull",1, R.drawable.lucesled,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(3, "Sticker Monster",1, R.drawable.vinilo,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(4, "Sticker Familia",1, R.drawable.funda_timon,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(5, "Sticker Cerveza",1, R.drawable.luces_llantas,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(6, "Sticker de Sangre",1, R.drawable.poalrizados,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(7, "Sticker Red Bull",1, R.drawable.lucesled,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(8, "Sticker Monster",1, R.drawable.vinilo,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(9, "Sticker Familia",1, R.drawable.funda_timon,1,"Diseno de sangre en vinil","VInil",1,true));
        disenos.add(new Diseno(10, "Sticker Cerveza",1, R.drawable.luces_llantas,1,"Diseno de sangre en vinil","VInil",1,true));

        configToolbar();
        configAdapter();
        configRecyclerView();
    }

    private void configRecyclerView() {
        recyclerviewDiseno.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewDiseno.addItemDecoration(new DividerItemDecoration(DisenoActivity.this, DividerItemDecoration.VERTICAL));
        recyclerviewDiseno.setAdapter(adapter);
    }

    private void configAdapter() {

        adapter = new DisenoAdapter(disenos, DisenoActivity.this);
    }

    private void configToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}