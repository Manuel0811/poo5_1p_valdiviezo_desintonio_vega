package com.pooespol.Persona;
public class Revisor extend persona{
    private String nombreJournal;
    private String contrasenia;
    private Usuario rol;
    private String user;

    public Revisor (String nombre, String apellido, String correo, String nombreJournal, String contrasenia, Usuario rol, String user){
        super(nombre, apellido,correo);
        this.nombreJournal = nombreJournal;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.user = user;
    }

    //Getters
    
    public String getNombreJournal(){
        return nombreJournal;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public Usiario getRol(){
        return rol;
    }

    public String getUser(){
        return user;
    }

    //Setters
    
    public void setNombreJournal(nombreJournal){
        this.nombreJournal = nombreJournal:
    }

    public void setContrasenia(contrasenia){
        this.contrasenia = contrasenia;
    }

    public void setRol(rol){
        this.rol = rol;
    }

    public void setUser(user){
        this.user = user;
    }

    //Metodos apartes
    
    
}
