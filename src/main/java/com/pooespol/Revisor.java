package com.pooespol;

public class Revisor extends Persona{
    private String nombreJournal;
    private String contrasenia;
    //private Usuario rol;
    private String user;

    public Revisor(String nombre, String apellido, String correo, String nombreJournal, String contrasenia, String user){
        super(nombre, apellido,correo);
        this.nombreJournal = nombreJournal;
        this.contrasenia = contrasenia;
        this.user = user;
    }

    //Getters
    
    public String getNombreJournal(){
        return nombreJournal;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public String getUser(){
        return user;
    }

    //Setters
    
    public void setNombreJournal(String nombreJournal){
        this.nombreJournal = nombreJournal;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public void setUser(String user){
        this.user = user;
    }

    //Metodos apartes
    
    
}
