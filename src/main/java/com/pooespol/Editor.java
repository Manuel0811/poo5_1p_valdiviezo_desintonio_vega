package com.pooespol;

public class Editor extends Persona{
    protected String journal;
    private String contrasenia;
    protected String user;

    public editor(String nombre, String apellido, String correo, String journal, String contrasena, String user, usuario rol) {
        super(nombre, apellido, correo, rol);
        this.journal = journal;
        this.contrasena = contrasena;
        this.user = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
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

    public void setRol(usuario rol) {
        this.rol = rol;
    }

    public usuario getRol() {
        return rol;
    }
}
