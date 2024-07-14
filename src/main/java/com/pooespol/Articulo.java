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

    /**
     * Este metodo permite acceder al Titulo del Articulo
     * @return retorna un String con el Titulo del Articulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Este metodo permite modificar el Titulo del Articulo
     * @param titulo recibe el nuevo Titulo del Articulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Este metodo permite accede al Resumen del Articulo
     * @return retornara un String con el Resumen del Articulo
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Este metodo permite modificar el Resumen del Articulo
     * @param resumen recibe el nuevo Resumen del Articulo
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * Este metodo permite acceder al Contenido del Articulo
     * @return retornara un String con el Contenido del Articulo
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Este metodo permite modificar el Contenido del Articulo
     * @param contenido recibe el nuevo Contenido del Articulo
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    /**
     * Este metodo permite acceder a la lista de las Palabras Claves del Articulo
     * @return retornara la lista de las Palabras Claves del Articulo
     */
    public ArrayList<String> getPalabrasClave() {
        return palabrasClaves;
    }

    /**
     * Este metodo permite modificar la lista de las Palabras Claves del Articulo
     * @param palabrasClaves recibe la nueva lista de Palabras Claves del Articulo
     */
    public void setPalabrasClave(ArrayList<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    /**
     * Este metodo permite acceder al Autor del Articulo
     * @return retorna el Autor del Articulo
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * Este metodo permite modificar el Autor del Articulo
     * @param autor recibe el nuevo Autor del Articulo
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    /**
     * Este metodo permite acceder a la lista de Aceptacion de los Revisores sobre el Artriculo
     * @return retorna la lista de Aceptacion del Articulo
     */
    public ArrayList<Boolean> getAceptacion(){
        return aceptacion;
    }

    /**
     * Este metodo permite modificar la lista de Aceptacion del Articulo
     * @param aceptacion recibe la lista de Aceptacion del Articulo
     */
    public void setAcetacion(ArrayList<Boolean> aceptacion){
        this.aceptacion = aceptacion;
    }

    /**
     * Este metodo crea un String con los atributos del Articulo
     * @return retorna un String con los atributos del Articulo
     */
    public String toString(){
        String palabras = "";
        for(String e: palabrasClaves){
            palabras+= " "+e;
        }
        String s= titulo+ "-"+resumen+"-"+contenido+"-"+palabras+"-"+autor.toString();
        return s;
    }

    /**
     * Este metodo permite comparar un Articulo con otro objeto
     * @param obj recibe un objeto con el se comparara
     * @return retorna true si el Articulo y el objeto son de la misma clase y sus atriutos son iguales
     */
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
