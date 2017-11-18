package com.iesnervion.agomez.galeriaimagenes;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by aleja on 18/11/2017.
 */

public class bitmapAdapter extends PagerAdapter
{
    private ArrayList <Bitmap> imagenes;
    private Context context;
    private LayoutInflater inflater;

    public bitmapAdapter (Context context, ArrayList<Bitmap> imagenes)
    {
        this.context = context;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return imagenes.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem (ViewGroup container, int position)
    {
        ImageView imagen;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.page, container, false);

        imagen = (ImageView) itemView.findViewById(R.id.imagen);
        imagen.setImageBitmap(imagenes.get(position));

        ((ViewPager) container).addView (itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view)
    {
        collection.removeView((View) view);
    }
}
