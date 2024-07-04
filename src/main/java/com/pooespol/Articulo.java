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
