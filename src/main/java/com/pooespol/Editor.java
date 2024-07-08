package com.pooespol;

import java.util.Scanner;

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

    public void decisionFinal(){
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
        for(int i = 0; i<Articulo.aceptacion.size();i++){
            if(Articulo.aceptacion.get(i)){
                System.out.println("El "+(i+1)+" revisor aprobo el articulo.");
            }else{
                System.out.println("El "+(i+1)+" revisor rechazo el articulo.");
            }
        }
        System.out.println("Decision Final");
        System.out.println("1. Publicar");
        System.out.println("2. No Publicar");   
        System.out.println("Escriba su decision: ");
        int decision = sc.nextInt();
        sc.nextLine();
        switch (decision) {
            case 1:
                System.out.println("El articulo sera publicado");
                break;
            case 2:
                System.out.println("El articulo no sera publicado");
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        sc.close();
    }
}
