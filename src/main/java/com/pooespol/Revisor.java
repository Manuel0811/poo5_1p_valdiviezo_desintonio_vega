package com.pooespol;

public class Revisor extends Persona{
    private String especialidad;
    private String user;
    private String contrasenia;
    private int articulosRevisados;
    

    public Revisor(String nombre, String apellido, String correo, Usuario rol, String especialidad, String user,String contrasenia, int articulosRevisados ){
        super(nombre, apellido,correo,rol);
        this.especialidad = especialidad;
        this.user = user;
        this.contrasenia = contrasenia;
        this.articulosRevisados = articulosRevisados;
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

    public ArrayList validarArticulo(Articulo articulo){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> validacion = new ArrayList<>();
        String respuesta = sc.nextLine();
        if (respuesta.toLowerCase() == "aceptado") {
            validacion.add(respuesta);
        } else if (respuesta.toLowerCase() == "rechazado") {
            validacion.add(respuesta);
        }
        return validacion;
    }
    
    
}
