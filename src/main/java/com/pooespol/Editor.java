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
    public Boolean decisionFinal(Articulo articulo) {
        Boolean decisionFinal=false;
        ArrayList<Boolean> validacion = articulo.getAceptacion();
        if (validacion.get(0) == true && validacion.get(1) == true) {
            decisionFinal = true;
        } else if (validacion.contains(false)) {
            Scanner sc = new Scanner(System.in);
            String respuesta = sc.nextLine();
            if (respuesta.toLowerCase().equals("aprobado")) {
                decisionFinal = true;
            } else if (respuesta.toLowerCase().equals("rechazado")) {
                decisionFinal = false;
            }
            sc.close();
        }
        
        return decisionFinal;
    }
}
