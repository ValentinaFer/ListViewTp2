package com.softulp.practica1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softulp.practica1.databinding.ItemBinding;
import com.softulp.practica1.modelo.Inmueble;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Inmueble> {
    //El adapter tiene como responsabilidad popular la ListView con data, es decir, conoce la lista de inmuebles y el listView que debe llenar en base a estos.
    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater layoutInflater;

    private ItemBinding binding;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects /*,LayoutInflater layoutInflater*/) {
        super(context, resource, objects);
        this.context = context;
        this.inmuebles = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView; //<-el item layout (esto es esencialmente lo mismo que binding.getRoot())
        if (itemView == null){ //no hay vista que reciclar asi que creamos una y la inflamos, ademas le agregamos un tag para poder reutilizarla luego
            //itemView = layoutInflater.inflate(R.layout.item, parent, false);
            binding = ItemBinding.inflate(layoutInflater, parent, false); //false porque no quiere que se inflen vistas hijas dentro
            convertView = binding.getRoot(); //<-el item layout, pero obtenido con binding (esencialmente lo mismo que recibimos en convertView).
            //tengo este binding.getRoot() aqui dentro del if para asegurar que se tiene el view correcto del item, se haya inflado recien or venga reciclada
            //esto porque, en caso de varias ListViews con sus propios adapter en una misma vista, por ejemplo, podria darse el caso de reciclar los item layout y estos ser distintos
            //entonces, me aseguro de obtener el layout correcto y no, el de otro ListView

            convertView.setTag(binding); //seteo tag para reciclar esa vista despues, llegada la condicion apta para ello, claro
        } else { //hay vista para reciclar, asi que la recuperamos con el tag previamente seteado (esta es la condicion apta jiji)
            binding = (ItemBinding)convertView.getTag(); //y la convertimos para poder reutilizarla
        }
        Inmueble inmueble = inmuebles.get(position);
        binding.ivImg.setImageResource(inmueble.getImg());
        binding.tvDireccion.setText(inmueble.getLocalidad());
        binding.tvPrecio.setText(inmueble.getPrecio()+"");
        return convertView;
    }

    //hay otros metodos que permiten modificar las listView dinamicamente sin requerir una "recarga" de la vista.
    @Override
    public int getCount() {
        return inmuebles.size();
    }
}
