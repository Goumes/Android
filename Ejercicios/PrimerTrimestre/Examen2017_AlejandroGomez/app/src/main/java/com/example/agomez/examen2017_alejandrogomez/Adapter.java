package com.example.agomez.examen2017_alejandrogomez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by agomez on 22/11/17.
 */

public class Adapter extends ArrayAdapter<Producto> {
    ArrayList<Producto> productos;

    public Adapter(Context context, int resource, ArrayList<Producto> productos) {
        super(context, resource, productos);
        this.productos = productos;
    }

    public int getItemViewType(int position) {
        int resultado = 0;

        if (getItem(position) instanceof ProductoModa) {
            resultado = 0;
        } else if (getItem(position) instanceof ProductoMueble) {
            resultado = 1;
        }

        return resultado;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        ViewHolderModa viewHolder = null;
        ViewHolderMueble viewHolder2 = null;
        int tipo = getItemViewType(position);

        switch (tipo) {
            case 0:

                if (vista == null) {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    vista = inflater.inflate(R.layout.row_moda, null);
                    viewHolder = new ViewHolderModa(vista);
                    vista.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolderModa) vista.getTag();
                }

                ProductoModa productoModa = (ProductoModa) getItem(position);

                if (productoModa != null) {
                    ImageView img = viewHolder.getFoto();
                    TextView txtcolor = viewHolder.getColor();
                    TextView txtprecio = viewHolder.getPrecio();
                    TextView txtcantidad = viewHolder.getCantidad();
                    TextView txttalla = viewHolder.getTalla();

                    //En estos sets pongo algunos valores estaticos porque no me da tiempo a implementar la busqueda de los atributos correspondientes

                    txtcolor.setText(productoModa.getColoresTallas().get(0).getColoresFotos().get(0).getColor());
                    txtcantidad.setText(String.valueOf(1));
                    txtprecio.setText(String.valueOf(productoModa.getPrecio()));
                    txttalla.setText(String.valueOf(productoModa.getColoresTallas().get(0).getTalla()));
                    img.setImageResource(productoModa.getColoresTallas().get(0).getColoresFotos().get(0).getFoto());
                }

                break;
            case 1:

                if (vista == null) {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    vista = inflater.inflate(R.layout.row_mueble, null);
                    viewHolder2 = new ViewHolderMueble(vista);
                    vista.setTag(viewHolder2);
                } else {
                    viewHolder2 = (ViewHolderMueble) vista.getTag();
                }

                ProductoMueble mueble = (ProductoMueble) getItem(position);

                if (mueble != null) {
                    ImageView img = viewHolder2.getFoto();
                    TextView txtcolor = viewHolder2.getColor();
                    TextView txtprecio = viewHolder2.getPrecio();
                    TextView txtcantidad = viewHolder2.getCantidad();

                    txtcolor.setText(mueble.getColoresFotos().get(0).getColor());
                    txtcantidad.setText(String.valueOf(1));
                    txtprecio.setText(String.valueOf(mueble.getPrecio()));
                    img.setImageResource(mueble.getColoresFotos().get(0).getFoto());
                }

                break;
        }


        return (vista);
    }
}
