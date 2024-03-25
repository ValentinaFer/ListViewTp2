package com.softulp.practica1.ui;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.practica1.R;
import com.softulp.practica1.databinding.ActivityMainBinding;
import com.softulp.practica1.modelo.Inmueble;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel vm;
    private ListViewAdapter adapter;

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        setContentView(binding.getRoot());


        adapter = new ListViewAdapter(this, R.layout.item, new ArrayList<Inmueble>());
        lv = binding.lvPropiedades;
        lv.setAdapter(adapter);

        vm.getLista().observe(this, newData -> {
            adapter.clear();
            adapter.addAll(newData);
        });

        ArrayList<Inmueble> inmuebles = new ArrayList<>();
        inmuebles.add(new Inmueble(R.drawable.casita1, "Juana Koslay", 800000));
        inmuebles.add(new Inmueble(R.drawable.casita2, "Potrero de los Funes", 500000));
        inmuebles.add(new Inmueble(R.drawable.casita3, "El Trapiche", 200000));
        inmuebles.add(new Inmueble(R.drawable.casita4, "San Luis", 300000));
        inmuebles.add(new Inmueble(R.drawable.casita5, "San Luis", 300000));
        inmuebles.add(new Inmueble(R.drawable.casita6, "San Luis", 300000));
        inmuebles.add(new Inmueble(R.drawable.casita7, "San Luis", 300000));
        vm.setLista(inmuebles);
    }
}