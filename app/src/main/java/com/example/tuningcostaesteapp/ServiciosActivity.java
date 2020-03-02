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
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiciosActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewServicios)
    RecyclerView recyclerviewServicios;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private ServicioAdapter adapter;
    private List<Servicio> servicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ServiciosActivity.this,AddServicioActivity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        servicios = new ArrayList<>();

        servicios.add(new Servicio(1, "Polarizados", R.drawable.poalrizados));
        servicios.add(new Servicio(2, "Luces LED", R.drawable.lucesled));
        servicios.add(new Servicio(3, "Sticker Vinilo", R.drawable.vinilo));
        servicios.add(new Servicio(4, "Fundas", R.drawable.funda_timon));
        servicios.add(new Servicio(5, "Llantas", R.drawable.luces_llantas));

        servicios.add(new Servicio(6, "Polarizados", R.drawable.poalrizados));
        servicios.add(new Servicio(7, "Luces LED", R.drawable.lucesled));
        servicios.add(new Servicio(8, "Sticker Vinilo", R.drawable.vinilo));
        servicios.add(new Servicio(9, "Fundas", R.drawable.funda_timon));
        servicios.add(new Servicio(10, "Llantas", R.drawable.luces_llantas));


        configToolbar();
        configAdapter();
        configRecyclerView();
    }

    private void configRecyclerView() {
        recyclerviewServicios.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewServicios.addItemDecoration(new DividerItemDecoration(ServiciosActivity.this, DividerItemDecoration.VERTICAL));
        recyclerviewServicios.setAdapter(adapter);
    }

    private void configAdapter() {

        adapter = new ServicioAdapter(servicios,ServiciosActivity.this);
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
