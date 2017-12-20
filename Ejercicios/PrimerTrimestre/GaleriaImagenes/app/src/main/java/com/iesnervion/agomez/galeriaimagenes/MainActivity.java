package com.iesnervion.agomez.galeriaimagenes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    int RESULT_LOAD_IMG;
    ImageView imagen;
    Button btn;
    ArrayList<Bitmap> imagenes;
    ViewPager viewPager;
    bitmapAdapter bitmapAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RESULT_LOAD_IMG = 0;
        imagen = (ImageView) findViewById(R.id.imagen);
        btn = (Button) findViewById(R.id.btnBuscar);
        imagenes = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.pager);
        bitmapAdapter = new bitmapAdapter(getApplicationContext(), imagenes);
        viewPager.setAdapter(bitmapAdapter);

    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data)
    {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK)
        {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                //InputStream imagenGlide;
                /*
                Glide.with(getApplicationContext())
                        .asBitmap()
                        .load(selectedImage)
                        .into(imagenGlide);
                */
                imagenes.add(Bitmap.createScaledBitmap(selectedImage, 1080, 1450, false));
                bitmapAdapter = new bitmapAdapter(getApplicationContext(), imagenes);
                viewPager.setAdapter(bitmapAdapter);



            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }

        else
        {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }

    public void click(View view)
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }

    public void clickGuardar(View view)
    {
        int resultado = viewPager.getCurrentItem();

        saveImageToExternalStorage(imagenes.get(resultado));
    }

    private void saveImageToExternalStorage(Bitmap finalBitmap)
    {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "prueba";

        File outputDir= new File(path);

        try
        {
            outputDir.mkdirs();
            File newFile = new File(path + "/" + "test.png");
            FileOutputStream out = new FileOutputStream(newFile);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
