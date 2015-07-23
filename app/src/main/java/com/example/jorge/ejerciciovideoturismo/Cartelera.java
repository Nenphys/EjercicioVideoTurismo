package com.example.jorge.ejerciciovideoturismo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Cartelera extends Activity {
    private UriDePeliculas dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        //Crear nuevo objeto UriDePeliculas
        dataSource = new UriDePeliculas(this);

        //Llenamos las celdas de la lista
        ArrayList<Llenado_Celda> datos = new ArrayList<Llenado_Celda>();
        datos.add(new Llenado_Celda(R.drawable.hombresdehonor, "Hombres de Honor"));
        datos.add(new Llenado_Celda(R.drawable.heradehielo4, "La Era de Hielo 4"));
        datos.add(new Llenado_Celda(R.drawable.vengadores, "Los Vengadores"));


        //Inflamos el listView
        ListView lista = (ListView) findViewById(R.id.listado);
        lista.setAdapter(new Adapter(this, R.layout.celda_imagen_pelicula, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView tituloPeli = (TextView) view.findViewById(R.id.tituloPelicula);
                tituloPeli.setText(((Llenado_Celda) entrada).get_tituloPeli());

                ImageView imagenPeli = (ImageView) view.findViewById(R.id.imagenPelicula);
                imagenPeli.setImageResource(((Llenado_Celda) entrada).get_imagenpeli());
            }
        });

        //Seleccionamos un item de la lista e iniciamos la activity de video
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {

                Intent i = new Intent(Cartelera.this, Video.class);

                i.putExtra("id", posicion);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cartelera, menu);
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
}
