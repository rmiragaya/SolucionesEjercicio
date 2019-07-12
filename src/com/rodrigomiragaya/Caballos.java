package com.rodrigomiragaya;

import java.util.Random;

public class Caballos extends Animales{

    public Caballos(String nomnbre) {
        super(nomnbre);
    }

    @Override
    public void comer() {
        if (new Random().nextInt(101) > 50){
            System.out.println(toString());
            System.out.println("Comiendo...");
            this.hambre -= 40;
            System.out.println(toString());
        } else {
            System.out.println("El caballo de nombre " + this.nombre + " no comió");
        }
    }

    @Override
    public void jugar() {
        if (this.energia>=50 && this.hambre < 25){
            System.out.println(toString());
        this.energia -= 12;
        this.hambre += 33;
            System.out.println("Jugando...");
            System.out.println(toString());
        } else {
            System.out.println(this.nombre + " No puede jugar");
            System.out.println(toString() + " // Niveles minimos para jugar: E >= 50 y H < 25");
        }
    }
}
