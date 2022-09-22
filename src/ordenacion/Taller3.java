package ordenacion;

import edu.princeton.cs.algs4.StdRandom;

public class Taller3 {

    public static void main(String[] args) {
        // punto 3
        Pelicula[] lista =Pelicula.leerCSV("C:\\Users\\julia\\OneDrive\\Escritorio\\Cuarto Semestre\\Estructura de datos y algoritmos\\Taller 3\\IMDb movies.csv");
        //Punto 4
        StdRandom.shuffle(lista);
        Pelicula.listarPorRating(lista);
        //Punto 6
        StdRandom.shuffle(lista);
        Pelicula.listarPorComparador(lista, Pelicula.comparadoraPeliculas.compDate);
        StdRandom.shuffle(lista);
        Pelicula.listarPorComparador(lista, Pelicula.comparadoraPeliculas.compTitle);

        /*Punto 8*/
        double promedio = 0;
        int k = 20;
        
        for (int i = 0; i < k; i++) {
            StdRandom.shuffle(lista);
            promedio += Pelicula.medirTiempoALG(lista, Pelicula.comparadoraPeliculas.compTitle);
        }
        System.out.println("Selection " + promedio/k);
        promedio=0;
        for (int i = 0; i < k; i++) {
            StdRandom.shuffle(lista);
            promedio += Pelicula.medirTiempoALG2(lista, Pelicula.comparadoraPeliculas.compTitle);
        }
        System.out.println("MergeX " + promedio/k);
        promedio=0;
        for (int i = 0; i < k; i++) {
            StdRandom.shuffle(lista);
            promedio += Pelicula.medirTiempoALG3(lista, Pelicula.comparadoraPeliculas.compTitle);
        }
        System.out.println("Array Sort " + promedio/k);
        
    }
    
}
