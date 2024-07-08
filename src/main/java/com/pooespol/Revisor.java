package com.pooespol;

import java.util.Scanner;
import java.util.ArrayList;

public class Revisor extends Persona{
    private String especialidad;
    private String user;
    private String contrasenia;
    private int articulosRevisados;
    

    public Revisor(String nombre, String apellido, String correo,String contraseniaCorreo, Usuario rol, String especialidad, String user,String contrasenia, int articulosRevisados ){
        super(nombre, apellido,correo,rol,contraseniaCorreo);
        this.especialidad = especialidad;
        this.user = user;
        this.contrasenia = contrasenia;
        this.articulosRevisados = articulosRevisados;
    }
    
    /**
     * Este metodo retornara la Especialidad del Revisor
     * @return Retorna el String de la Especialidad del Editor
     */
    public String getEspecialidad(){
        return especialidad;
    }

    /**
     * Este metodo retornara la Contraseña del Revisor
     * @return Retornara un String de la Contraseña del Editor
     */
    public String getContrasenia(){
        return contrasenia;
    }

    /**
     * Este metodo retornara el User del Revisor
     * @return Retornara un String del User del Editor
     */
    public String getUser(){
        return user;
    }

    /**
     * Este metodo retornara la cantidad de Articulos Revisados del Revisor
     * @return Retornara un int de la cantidad de Articulos Revisados
     */
    public int getArticulosRevisados(){
        return articulosRevisados;
    }
    
    /**
     * Este metodo permite modificar la Especialidad del Revisor
     * @param especialidad Sera la nueva especialidad del Revisor
     */
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    /**
     * Este metodo permite modificar la Contraseña del Revisor
     * @param contrasenia Sera la nueva Contraseña del Revisor
     */
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    /**
     * Este metodo permite modificar el User del Revisor
     * @param user Sera el nuevo User del Revisor
     */
    public void setUser(String user){
        this.user = user;
    }

    /**
     * Este metodo permite modificar la cantidad de Articulos Revisados del Revisor
     * @param articulosRevisados Seran la nueva cantidad de Articulos Revisados
     */
    public void setArticulosRevisados(int articulosRevisados){
        this.articulosRevisados = articulosRevisados;
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
            Revisor revisor2 = (Revisor)obj;
            if((nombre.equals(revisor2.getNombre())) && (apellido.equals(revisor2.getApellido())) && (correo.equals(revisor2.getCorreo())) && (especialidad.equals(revisor2.getEspecialidad())) && (user.equals(revisor2.getUser()))&&(contrasenia.equals(revisor2.getContrasenia()))&& (articulosRevisados==revisor2.getArticulosRevisados())&&(contraseniaCorreo.equals(revisor2.getcontraseniaCorreo())))
                return true;
        }
        return false;    
    }
    
    /**
     * Con este metodo el Revisor lee el artculo designado y posterior lo acepta o rechaza para que el deitor decida si publicarlo o no
     */
    public void validarArticulo(){
        Scanner sc = new Scanner(System.in);
        String mensaje =Aplicacion.leerCorreo(this);
        System.out.println(mensaje);
        System.out.println("Desea asignar el articulo a un Editor");
        System.out.println("1. Aceptar");
        System.out.println("2. Rechazar");
        System.out.println("Escriba su opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1:
                Articulo.aceptacion.add(true);
                break;
            case 2:
                Articulo.aceptacion.add(false);
                break;
            default:
                System.out.println("Opcion Invalida");
        }
        String[] articulo = mensaje.split("-");
        ArrayList<String> palabrasClaves = new ArrayList<>();
        String[] palabras = articulo[3].split(" ");
        for(String e: palabras){
            palabrasClaves.add(e);
        }
        String nombreAutor = articulo[4];
        Autor autor = null;
        for(Persona e: Aplicacion.personas){
            if(e instanceof Autor){
                Autor a1 = (Autor)e;
                if(nombreAutor.equals(a1.getNombre()));
                autor = a1;
            }
        }
        Articulo art = new Articulo(articulo[0],articulo[1],articulo[2],palabrasClaves,autor);
        Editor edi = null;
        for(Persona e: Aplicacion.personas){
            if(e instanceof Editor){
                Editor editor = (Editor)e;
                edi = editor;
            }
        }
        Aplicacion.enviarCorreos(this, edi, "Publicaion de articulo", art);
        sc.close();
    }
    
    
}
