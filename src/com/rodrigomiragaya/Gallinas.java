package com.rodrigomiragaya;

import java.util.Random;

public class Gallinas extends Animales{

    public Gallinas(String nomnbre) {
        super(nomnbre);
    }

    @Override
    public void comer() {
        System.out.println(toString());
        System.out.println("Comiendo...");
        this.hambre -= 30;
        System.out.println(toString());
    }

    @Override
    public void jugar() {
        if (this.energia>=20 && this.hambre < 40){
            System.out.println(toString());
            this.hambre += 20;
            this.energia -=(new Random().nextInt(50 - 20) + 20);
            System.out.println("Jugando...");
            System.out.println(toString());
        } else {
            System.out.println(this.nombre +" No puede jugar");
            System.out.println(toString() + "// Niveles minimos para jugar: E >= 20 y H < 40");

        }

    }
}
