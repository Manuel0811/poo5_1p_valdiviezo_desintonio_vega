package com.pooespol;

import java.util.Scanner;
import java.util.ArrayList;

public class Editor extends Persona{
    protected String journal;
    private String contrasenia;
    protected String user;

    public Editor(String nombre, String apellido, String correo, String journal, String contrasena, String user, Usuario rol) {
        super(nombre,apellido,correo,rol);
        this.journal = journal;
        this.contrasenia = contrasena;
        this.user = user;
    }

    /**
     * Permite acceder a la contraseña del Editor
     * @return Retorrna un String de la contrañesa del Editor
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Este metodo permite modificar la contraseña del Editor
     * @param contrasenia Sera la nueva contraseña del Editor
     */
    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Este metodo permite modificar el Journal que trabaja el Editor
     * @param journal Sera el nuevo Journal del Editor
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * Este metodo permite mirar el Journal que trabaja el Editor
     * @return Retorna un String del Journal del Editor
     */
    public String getJournal() {
        return journal;
    }

    /**
     * Este metodo permite modificar el User del Editor
     * @param user Sera el nuevo User del Editor
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Este metodo permite mirar el User del Editor
     * @return Retorna un String del User del Editor
     */
    public String getUser() {
        return user;
    }

    /**
     * Este metodo permiter ver las decisiones de los Revisores respecto a un articulo y posteriro tomar la decision de publicarlo o no publicarlo
     */
    public void decisionFinal(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Articulo> articulos =Aplicacion.articulos;
        for(Articulo e: articulos){
            System.out.println("Articulo por publicar");
            System.out.println(e);
            for(int i = 0; i<e.getAceptacion().size();i++){
                if(e.getAceptacion().get(i)){
                    System.out.println("El "+(i+1)+" revisor aprobo el articulo.");
                }else{
                    System.out.println("El "+(i+1)+" revisor rechazo el articulo.");
                }
            }
            int decision = 0;
            do{
                System.out.println("Decision Final");
                System.out.println("1. Publicar");
                System.out.println("2. No Publicar");   
                System.out.println("Escriba su decision: ");
                decision = sc.nextInt();
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
            }while((decision!=1)&&(decision!=2));
            System.out.println("Siguiente Articulo por aprobar");
        }
        System.out.println("Ya no hay mas articulos por aprobar");
    }
}
