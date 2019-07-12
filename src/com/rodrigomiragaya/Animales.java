package com.rodrigomiragaya;

import java.io.Serializable;

public abstract class Animales implements IAnimales, Serializable {

    protected String nombre;
    protected int energia;
    protected int hambre;


    public Animales(String nomnbre) {
        this.nombre = nomnbre;
        this.energia = 100;
        this.hambre = 0;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void dormir() {
        this.hambre += 35;
        this.energia = 100;
        System.out.println(this.nombre + " se fue a Dormir");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " ( E: " + energia + " / H: " + hambre + " )";
    }
}
