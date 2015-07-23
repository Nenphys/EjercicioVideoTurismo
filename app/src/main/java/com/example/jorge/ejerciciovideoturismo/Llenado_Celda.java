package com.example.jorge.ejerciciovideoturismo;

/**
 * Created by Jorge on 20/07/2015.
 */
public class Llenado_Celda {
    private int idImagen;
    private String tituloPelicula;


    public Llenado_Celda (int idImagen, String tituloPelicula) {
        this.idImagen = idImagen;
        this.tituloPelicula = tituloPelicula;

    }

    public String get_tituloPeli() {
        return tituloPelicula;
    }



    public int get_imagenpeli() {
        return idImagen;
    }
}
