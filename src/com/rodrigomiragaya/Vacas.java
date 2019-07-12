package com.rodrigomiragaya;

public class Vacas extends Animales{

    public Vacas(String nomnbre) {
        super(nomnbre);
    }

    @Override
    public void comer() {
        System.out.println(toString());
        System.out.println("Comiendo...");
        this.hambre -= 23;
        System.out.println(toString());
    }

    @Override
    public void jugar() {
        if (this.energia>=30 && this.hambre < 20){
            System.out.println(toString());
        this.energia -= 15;
        this.hambre += 20;
            System.out.println("Jugando...");
            System.out.println(toString());
        } else {
            System.out.println(this.nombre +" No puede jugar");
            System.out.println(toString() + "// Niveles minimos para jugar: E >= 30 y H < 20");

        }

    }


}
