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
        View itemView = convertView;
        if (itemView == null){ //no hay vista que reciclar asi que creamos una y la inflamos, ademas le agregamos un tag para poder reutilizarla luego
            //itemView = layoutInflater.inflate(R.layout.item, parent, false);
            binding = ItemBinding.inflate(layoutInflater, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else { //hay vista para reciclar, asi que la recuperamos con el tag previamente seteado
            binding = (ItemBinding)convertView.getTag();
        }
        Inmueble inmueble = inmuebles.get(position);
        binding.ivImg.setImageResource(inmueble.getImg());
        binding.tvDireccion.setText(inmueble.getLocalidad());
        binding.tvPrecio.setText(inmueble.getPrecio()+"");
        return convertView;
    }
}
