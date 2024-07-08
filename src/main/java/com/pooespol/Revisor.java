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
    
    public String getEspecialidad(){
        return especialidad;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public String getUser(){
        return user;
    }

    public int getArticulosRevisados(){
        return articulosRevisados;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public void setUser(String user){
        this.user = user;
    }
    public void setArticulosRevisados(int articulosRevisados){
        this.articulosRevisados = articulosRevisados;
    }
    
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
