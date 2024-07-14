package com.pooespol;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Autor extends Persona{
    public static int CODIGOID;
    private String institucion;
    private String campoInvestigacion;

    public Autor(String nombre, String apellido, String correo,Usuario rol, String institucion, String campoInvestigacion){
        super(nombre,apellido,correo,rol);
        this.institucion = institucion;
        this.campoInvestigacion = campoInvestigacion;
        CODIGOID++;
    }
    /**
     * Este metodo permite mirar la Institucion del Autor
     * @return Sera el nombre de la Institucion del Autor
     */
    public String getInstitucion(){
        return institucion;
    }

    /**
     * Este metodo permite mirar el Campo de Investigacion del Autor
     * @return Sera el nombre del Campo de Investigacion del Autor
     */
    public String getCampoInvestigacion(){
        return campoInvestigacion;
    }

    /**
     * Este metodo permite modificar la Institucion del Autor
     * @param institucion Sera la nueva Institucion del Autor
     */
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }

    /**
     * Este metodo permite modificar el Campor de Investigacion del Autor
     * @param campoInvestigacion Sera el nuevo Campo de Investigacion del Autor
     */
    public void setCampoInvestigacion(String campoInvestigacion){
        this.campoInvestigacion= campoInvestigacion;
    }
    
     /**
     * Este metodo compara dos Revisores segun todos sus atributos
     * @param obj Sera el objeto o revisor con el que se comparara
     * @return Retornara verdadero si tdoso los atributos son iguales, falso por el contrario
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass()){
            Autor autor2 = (Autor)obj;
            if((nombre.equals(autor2.getNombre())) && (apellido.equals(autor2.getApellido())) && (correo.equals(autor2.getCorreo())) && (institucion.equals(autor2.getInstitucion())) && (campoInvestigacion.equals(autor2.getCampoInvestigacion()))){
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo permite al autor subir un articulo y guardarlo en un archivo .txt
     * @return retornara el articulo que se creo
     */
    public Articulo crearArticulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingre el titulo del articulo: ");
        String titulo = sc.nextLine();
        System.out.println("Ingre un resumen del articulo: ");
        String resumen = sc.nextLine();
        System.out.println("Ingre el contenido del articulo: ");
        String contenido = sc.nextLine();
        System.out.println("Ingre cuantas palabras claves del articulo va a agregar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        ArrayList<String> palabrasClaves = new ArrayList<>();
        for(int i =0; i<cantidad;i++){
            System.out.println("Ingre la palabra clave del articulo: ");
            String palabra = sc.nextLine();
            palabrasClaves.add(palabra);
        }
        Articulo art = new Articulo(titulo, resumen, contenido, palabrasClaves, this);

        String linea = art.toString();
        Aplicacion.guardarDatos("articulos", linea);
        Aplicacion.articulos.add(art);
        return art;

    }

    /**
     * Este metodo manda el Articulo que el autor subio a dos Revisores para que tomen la decision de aceptarlo o rechazarlo
     */
    public void enviarArticulo(){
        System.out.println("Vamos a registrar su articulo");
        Articulo art = this.crearArticulo();
        System.out.println("Articulo creado");
        System.out.println("Ahora se enviara a dos revisores para su aceptacion");
        ArrayList<Revisor> revisores  = new ArrayList<>();
        Revisor revisor = null;
        Random r = new Random();
        do{
            int e = r.nextInt(Aplicacion.personas.size());
            Persona p = Aplicacion.personas.get(e);
            if(p instanceof Revisor ){
                Revisor rev = (Revisor)p;
                if(!rev.equals(revisor)){
                    revisores.add(rev);                
                }
            }
        }while(revisores.size()<2);
        for(Revisor i : revisores){
            Aplicacion.enviarCorreos(this, i, "Revision de Articulo",art);
        }
        System.out.println("Se envio su articulo exitosamente");
    }

    public String toString(){
        String s = "\nNomre: "+ nombre +" \nApellido: "+ apellido+ " \nCorreo: "+correo+" \nInstitucion: "+institucion+" \nCampo de Invesigacion: "+campoInvestigacion;
        return s;
    }
}
