package com.pooespol;
import java.util.ArrayList;

public class Articulo {
    public int codigoId;
    private  String titulo;
    private String resumen;
    private String contenido;
    private ArrayList<String> palabrasClaves;
    private Autor autor;
    public static ArrayList<Boolean> aceptacion;

    public Articulo(String titulo, String resumen, String contenido, ArrayList<String> palabrasClaves, Autor autor) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.palabrasClaves = palabrasClaves;
        this.autor = autor;
        aceptacion = new ArrayList<>();
        codigoId ++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClaves;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String toString(){
        String palabras = "";
        for(String e: palabrasClaves){
            palabras+= " "+e;
        }
        String s= titulo+ "-"+resumen+"-"+contenido+"-"+palabras+"-"+autor.getNombre();
        return s;
    }
}
