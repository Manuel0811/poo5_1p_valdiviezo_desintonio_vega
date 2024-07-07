package com.pooespol;

public class Editor extends Persona{
    protected String journal;
    private String contrasenia;
    protected String user;

    public Editor(String nombre, String apellido, String correo,String contraseniaCorreo, String journal, String contrasena, String user, Usuario rol) {
        super(nombre,apellido,correo,rol,contraseniaCorreo);
        this.journal = journal;
        this.contrasenia = contrasena;
        this.user = user;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournal() {
        return journal;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setRol(Usuario rol) {
        this.rol = rol;
    }

    public Usuario getRol() {
        return rol;
    }
}
