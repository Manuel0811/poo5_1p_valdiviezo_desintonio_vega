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

    //Metodos apartes
    
    
}
