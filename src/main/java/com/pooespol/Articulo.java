package com.pooespol;
import java.util.ArrayList;

public class Articulo {
    public int codigoId;
    private  String titulo;
    private String resumen;
    private String contenido;
    private ArrayList<String> palabrasClaves;
    private Autor autor;
    private ArrayList<Boolean> aceptacion;

    public Articulo(int codigoId, String titulo, String resumen, String contenido, ArrayList<String> palabrasClaves, Autor autor, ArrayList<Boolean> aceptacion) {
        this.codigoId = codigoId;
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.palabrasClaves = palabrasClaves;
        this.autor = autor;
        this.aceptacion = aceptacion;
    }
    public int getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(int codigoId) {
        this.codigoId = codigoId;
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

    public autor getAutor() {
        return autor;
    }

    public void setAutor(autor autor) {
        this.autor = autor;
    }

    public ArrayList<Boolean> getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(ArrayList<Boolean> aceptacion) {
        this.aceptacion = aceptacion;
    }
}
