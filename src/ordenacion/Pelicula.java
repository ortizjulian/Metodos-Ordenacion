package ordenacion;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Stopwatch;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;


public class Pelicula implements Comparable<Pelicula>{
    
     /*Punto 1*/
    
    private String imdb_title_id;
    private String title;
    private String original_title;
    private int year;
    private Date date_published;
    private String genre;
    private int duration;
    private String country;
    private String language;
    private String director;
    private String writer;
    private String production_company;
    private String actores;
    private String description;
    private float avg_vote;
    private int votes;
    private String budget;
    private String usa_gross_income;
    private String worlwide_gross_income;
    private String metascore;
    private float reviews_from_users;
    private String reviews_from_crtics;
    
    @Override
    public String toString() {
       return title + " " + avg_vote;
    }
    
    /*Punto 2*/
    @Override
    public int compareTo(Pelicula pelicula) {
        return Float.compare(this.avg_vote, pelicula.avg_vote);
    }
    
    /*3*/
    public static Pelicula[] leerCSV(String ruta){    
        try
        {
            In in = new In(ruta);
            in.readLine();
           
            ArrayList<Pelicula> lista = new ArrayList<>();
            
            while (!in.isEmpty()) {
                String line = in.readLine();
                String[] fields = null;
                fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                lista.add(arrayToAdt(fields));
                
            }
            
            Pelicula[] listaPeliculas =lista.toArray(new Pelicula[] {});
            return listaPeliculas;
        }
        
        catch(Exception e){
            System.out.println(e.toString());
            return null;

        }
    }
    
    private static Pelicula arrayToAdt(String[] fields){
        try{
            Pelicula pelicula= new Pelicula();
            pelicula.imdb_title_id = fields[0];
            pelicula.title=  fields[1] ;
            pelicula.original_title =  fields[2];
            pelicula.year= Integer.valueOf(fields[3]);
            pelicula.date_published = parseDate(fields[4]);
            pelicula.genre = fields[5];
            pelicula.duration = Integer.valueOf(fields[6]);
            pelicula.country = fields[7];
            pelicula.language = fields[8];
            pelicula.director = fields[9];
            pelicula.writer = fields[10];
            pelicula.production_company = fields[11];
            pelicula.actores = fields[12];
            pelicula.description = fields[13];
            pelicula.avg_vote = Float.valueOf(fields[14]);
            pelicula.votes = Integer.valueOf(fields[15]);
            pelicula.budget = (fields[16]);
            pelicula.usa_gross_income = fields[17];
            pelicula.worlwide_gross_income = fields[18];
            pelicula.metascore = fields[19];
            pelicula.reviews_from_users = parseFloat(fields[20]);
            pelicula.reviews_from_crtics = (fields.length>21) ? fields[21] : null;
            return pelicula;
        }
        catch(Exception error)
        {
            return null;
        }
    }
    
    private static float parseFloat(String s) {
        try {
            return Float.valueOf(s);
        }
        catch(NumberFormatException e) {
            return 0.0f;
        }
    }
    
    private static Date parseDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfz = new SimpleDateFormat("'TV Movie 'yyyy");
        if (s.indexOf(' ')>=0) return sdfz.parse(s);
        else if (s.indexOf('-')<0) return sdfy.parse(s);
        return sdf.parse(s);
    }
    
    /*Punto 4*/
    public static void listarPorRating(Pelicula[] peli){   
        Stopwatch tiempo = new Stopwatch();
        Quick.sort(peli);
        double transcurrido = tiempo.elapsedTime();
    }
    
    /*Punto 5*/
    static public class comparadoraPeliculas{
        //Comparator por titulo
        static Comparator<Pelicula> compTitle = (p1,p2) -> {return p1.title.compareTo(p2.title);};
        //Comparator por fecha de publicación
        static Comparator<Pelicula> compDate = (p1,p2) -> {return p1.date_published.compareTo(p2.date_published);};
    }
    
    /*Punto 6*/
    static public void listarPorComparador(Pelicula[] listaPeliculas, Comparator comparador){
        Insertion.sort(listaPeliculas, comparador);
        Pelicula.ImprimirLista(listaPeliculas);
    } 
    
    /*7*/
    static public double medirTiempoALG(Pelicula[] listaPeliculas, Comparator comparador){
        Stopwatch tiempo = new Stopwatch();
        Selection.sort(listaPeliculas, comparador);   
        return tiempo.elapsedTime();    
    }
    
    static public double medirTiempoALG2(Pelicula[] listaPeliculas, Comparator comparador){
        Stopwatch tiempo = new Stopwatch();
        MergeX.sort(listaPeliculas, comparador);      
        return tiempo.elapsedTime();    
    }
    
    static public double medirTiempoALG3(Pelicula[] listaPeliculas, Comparator comparador){
        Stopwatch tiempo = new Stopwatch();
        Arrays.sort(listaPeliculas, comparador);
        return tiempo.elapsedTime();
    }

    static public void ImprimirLista(Pelicula[] lista){
        for(Pelicula x : lista){
            System.out.println(x);
        }
    }
}
