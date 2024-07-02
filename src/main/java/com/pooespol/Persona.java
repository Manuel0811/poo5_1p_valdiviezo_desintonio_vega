package com.pooespol;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Usuario rol;

    public Persona(String nombre, String apellido, String correo, Usuario rol){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = rol;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getCorreo(){
        return correo;
    }

    public Usuario getRol(){
        return rol;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setRol(Usuario rol){
        this.rol = rol;
    }


}
