package com.example.tuningcostaesteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

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

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private SubCategoriaAdapter adapter;
    private List<SubCategoria> subCategorias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Autos");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        subCategorias=new ArrayList<>();

        subCategorias.add(new SubCategoria(1,"Polarizados",R.drawable.poalrizados));
        subCategorias.add(new SubCategoria(2,"Luces LED",R.drawable.lucesled));
        subCategorias.add(new SubCategoria(3,"Sticker Vinilo",R.drawable.vinilo));
        subCategorias.add(new SubCategoria(4,"Fundas",R.drawable.funda_timon));
        subCategorias.add(new SubCategoria(5,"Llantas",R.drawable.luces_llantas));

        subCategorias.add(new SubCategoria(6,"Polarizados",R.drawable.poalrizados));
        subCategorias.add(new SubCategoria(7,"Luces LED",R.drawable.lucesled));
        subCategorias.add(new SubCategoria(8,"Sticker Vinilo",R.drawable.vinilo));
        subCategorias.add(new SubCategoria(9,"Fundas",R.drawable.funda_timon));
        subCategorias.add(new SubCategoria(10,"Llantas",R.drawable.luces_llantas));


        configToolbar();
        configAdapter();
        configRecyclerView();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void configRecyclerView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        recyclerview.setAdapter(adapter);
    }
    private void configAdapter() {

        adapter=new SubCategoriaAdapter(subCategorias,this);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**********
     *  Metodos implementador por la interfaz onitemCLicklistener
     * **********/
    @Override
    public void onItemClick(SubCategoria subCategoria) {
        Intent intent=new Intent(MainActivity.this,DisenosActivity.class);
        startActivity(intent);

    }

    @Override
    public void onLongItemClick(SubCategoria subCategoria) {

    }
}
