package com.pooespol;

import java.util.Scanner;
import java.util.ArrayList;

public class Autor extends Persona{
    public static int CODIGOID;
    private String institucion;
    private String campoInvestigacion;

    public Autor(String nombre, String apellido, String correo,String contraseniaCorreo,Usuario rol, String institucion, String campoInvestigacion){
        super(nombre,apellido,correo,rol,contraseniaCorreo);
        this.institucion = institucion;
        this.campoInvestigacion = campoInvestigacion;
        CODIGOID++;
    }
    /**
     * Este metodo permite visualizar la Institucion del Autor
     * @return El nombre de la INstitucion del autor
     */
    public String getInstitucion(){
        return institucion;
    }

    public String getCampoInvestigacion(){
        return campoInvestigacion;
    }

    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }

    public void setCampoInvestigacion(String campoInvestigacion){
        this.campoInvestigacion= campoInvestigacion;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass()){
            Autor autor2 = (Autor)obj;
            if((nombre.equals(autor2.getNombre())) && (apellido.equals(autor2.getApellido())) && (correo.equals(autor2.getCorreo())) && (institucion.equals(autor2.getInstitucion())) && (campoInvestigacion.equals(autor2.getCampoInvestigacion()))&& (contraseniaCorreo.equals(autor2.getcontraseniaCorreo())))
                return true;
        }
        return false;
    }

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
        sc.close();
        String linea = art.toString();
        Aplicacion.guardarDatos("articulos", linea);
        return art;

    }

    public void enviarArticulo(){
        Articulo art = this.crearArticulo();
        ArrayList<Revisor> revisores  = new ArrayList<>();
        Revisor revisor = null;
        for(Persona e : Aplicacion.personas){
            if(e instanceof Revisor){
                Revisor revi = (Revisor)e;
                if(!revi.equals(revisor)){
                    revisores.add(revi);
                }
            }
        }
        for(Revisor e : revisores){
            Aplicacion.enviarCorreos(this, e, "Revision de Articulo",art);
        }

    }
}
