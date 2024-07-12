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
    
    public ArrayList<Boolean> getAceptacion(){
        return aceptacion;
    }

    public void setAcetacion(ArrayList<Boolean> aceptacion){
        this.aceptacion = aceptacion;
    }

    public String toString(){
        String palabras = "";
        for(String e: palabrasClaves){
            palabras+= " "+e;
        }
        String s= titulo+ "-"+resumen+"-"+contenido+"-"+palabras+"-"+autor.toString();
        return s;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass()){
            Articulo articulo2 = (Articulo)obj;
            if((titulo.equals(articulo2.getTitulo())) && (resumen.equals(articulo2.getResumen())) && (contenido.equals(articulo2.getContenido())) && (autor.toString().equals(articulo2.getAutor().toString()))&&(palabrasClaves.size()==articulo2.palabrasClaves.size())){
                return true;
            }
        }
        return false;    
        
    }
}
