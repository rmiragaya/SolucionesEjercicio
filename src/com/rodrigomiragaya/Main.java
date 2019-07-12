package com.rodrigomiragaya;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    //txt para save y load
    private static final String BACKUP_FILE_NAME = "backListaAnimales.txt";

    private static Scanner s1 = new Scanner(System.in);
    private static List<Animales> stockAnimales = new ArrayList<>();


    public static void main(String[] args) {

        opcionesMenu();

    }

    private static void opcionesMenu() {

        imrpimirMenu();

        while (true) {

            String opcion = s1.nextLine().toLowerCase();

            switch (opcion) {
                case "1":
                    listaAnimal();
                    break;
                case "2":
                    listarAnimales();
                    break;
                case "3":
                    agregarAnimal();
                    break;
                case "4":
                    alimenterAnimal();
                    break;
                case "5":
                    alimentarTodos();
                    break;
                case "6":
                    jugarAnimal();
                    break;
                case "7":
                    jugarTodos();
                    break;
                case "8":
                    dormirAnimal();
                    break;
                case "9":
                    dormirTodos();
                    break;
                case "exit":
                    System.out.println("Saliendo...");
                    return;
                case "clean":
                    clean();
                    break;
                case "save":
                    guardarDatos();
                    break;
                case "load":
                    cargarDatos();
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelva a intentarlo");
                    break;

            }
            imrpimirMenu();
        }
    }


    //imprime menu
    private static void imrpimirMenu() {
        System.out.println("------------------------------------\n" +
                "Opciones :");
        System.out.println("1. Listar Animal\n" +
                "2. Listar Animales\n" +
                "3. Agregar Animal\n" +
                "4. Alimentar Animal\n" +
                "5. Alimentar Animales\n" +
                "6. Jugar con Animal\n" +
                "7. Jugar con Animales\n" +
                "8. Descansar Animal\n" +
                "9. Descansar Animales\n" +
                "------------------------------------\n" +
                "* Para salir ingrese: exit\n" +
                "* Para limpiar la pantalla ingrese: clean\n" +
                "* Para guardar datos del sistema: save\n" +
                "* Para cargar datos del sistema: load\n" +
                "------------------------------------\n" +
                "Opción:");
    }


    //imprime 1 animal
    private static void listaAnimal() {
        if (listaVacia()) {
            return;
        }
        System.out.print("Ingrese el nombre del animal: ");
        String nombre = s1.nextLine().toLowerCase();
        if (encontrarAnimal(nombre) == null) {
            System.out.println("Ese animal no está en la lista");
        } else {
            System.out.println("Animal encontrado:");
            System.out.println(Objects.requireNonNull(encontrarAnimal(nombre)).toString());
        }
    }

    //imprime todos los anilames
    private static void listarAnimales() {
        if (listaVacia()) {
            return;
        }
        for (Animales animales : stockAnimales) {
            System.out.println(animales.toString());
        }

    }

    //agrega 1 animal
    private static void agregarAnimal() {
        System.out.println("Que nombre va a llevar el animal?:");
        String nombreAnimal = s1.nextLine().toLowerCase();
        if (encontrarAnimal(nombreAnimal) != null) {
            System.out.println("Ya hay un animal con ese nombre!");
            agregarAnimal();
        } else {
            System.out.println("Que tipo de animal desea agregar?:\n" +
                    "1. Gallina\n" +
                    "2. Vaca\n" +
                    "3. Caballo\n");
            String tipo = s1.nextLine().toLowerCase();
            switch (tipo) {
                case "1": case "gallina":
                    stockAnimales.add(new Gallinas(nombreAnimal));
                    break;
                case "2": case "vaca":
                    stockAnimales.add(new Vacas(nombreAnimal));
                    break;
                case "3": case "caballo":
                    stockAnimales.add(new Caballos(nombreAnimal));
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    return;
            }

            System.out.println(nombreAnimal + " ingresado a la lista");
        }
    }


    //alimenta 1 animal
    private static void alimenterAnimal() {
        if (listaVacia()) {
            return;
        }
        System.out.println("A que animal desea alimentar? ");
        String nombreAnimal = s1.nextLine().toLowerCase();
        Animales animal = encontrarAnimal(nombreAnimal);
        if (animal == null) {
            System.out.println("Ese animal no está en la lista");
        } else {
            animal.comer();
        }
    }


    //alimenta todos los animales
    private static void alimentarTodos() {
        if (listaVacia()) {
            return;
        }
        for (Animales animal : stockAnimales) {
            animal.comer();
        }
    }


    //juega con 1 animal
    private static void jugarAnimal() {
        if (listaVacia()) {
            return;
        }
        System.out.println("Con que animal quiere jugar? ");
        String nombreAnimal = s1.nextLine().toLowerCase();
        Animales animal = encontrarAnimal(nombreAnimal);
        if (animal == null) {
            System.out.println("Ese animal no está en la lista");
        } else {
            animal.jugar();
        }
    }

    //juega con todos los animales
    private static void jugarTodos() {
        if (listaVacia()) {
            return;
        }
        for (Animales animal : stockAnimales) {
            animal.jugar();
        }
    }


    //duerme un animal
    private static void dormirAnimal() {
        if (listaVacia()) {
            return;
        }
        System.out.println("Que animal desea que descanse? ");
        String nombreAnimal = s1.nextLine().toLowerCase();
        Animales animal = encontrarAnimal(nombreAnimal);
        if (animal == null) {
            System.out.println("Ese animal no está en la lista");
        } else {
            animal.dormir();
        }
    }

    //duermen todos los animales
    private static void dormirTodos() {
        if (listaVacia()) {
            return;
        }
        for (Animales animal : stockAnimales) {
            animal.dormir();
        }

    }

    //save
    private static void guardarDatos() {

        try {
            ObjectOutputStream oS = new ObjectOutputStream(new FileOutputStream(BACKUP_FILE_NAME));
            oS.writeObject(stockAnimales);

            oS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Datos guardados en " + BACKUP_FILE_NAME);
    }


    //load
    private static void cargarDatos() {

        try {
            ObjectInputStream oI = new ObjectInputStream(new FileInputStream(BACKUP_FILE_NAME));
            stockAnimales = (List<Animales>) oI.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Datos cargados de " + BACKUP_FILE_NAME);

        for (Animales animales : stockAnimales) {
            System.out.println(animales.toString());
        }
    }


    //cleanConsole
    private static void clean() {

        // MI solución por no haber encontrado como limpiar la consola
        for (int i = 0; i < 50; ++i) System.out.println();
        // MI solución por no haber encontrado como limpiar la consola

    }


    //Comprueba si la lista está vacia + print
    private static boolean listaVacia() {
        if (stockAnimales.isEmpty()) {
            System.out.println("No hay animales ingresados, lista vacia");
            return true;
        }
        return false;
    }


    //encuentra y devuelve el animal buscado por nombre
    private static Animales encontrarAnimal(String nombreAnimal) {
        for (Animales animal : stockAnimales) {
            if (animal.getNombre().toLowerCase().equals(nombreAnimal)) {
                return animal;
            }
        }
        return null;

    }


}





