package com.softulp.practica1.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.practica1.modelo.Inmueble;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> lista = new MutableLiveData<>();
    private ArrayList<Inmueble> arr;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Inmueble>> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Inmueble> inmuebles){
        lista.setValue(inmuebles);
    }

}
