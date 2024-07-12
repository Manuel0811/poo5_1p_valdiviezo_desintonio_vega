package com.pooespol;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Aplicacion.agregarPersonas("usuarios.txt");
        int opcion = 0;
        do{
            System.out.println("Bienvenido a la Aplicacion para publicacion de articulos");
            System.out.println("Escriba el numero de la accion que desea realizar");
            System.out.println("Someter Articulo: 1 \nIniciar Sesion: 2 \nSalir: 3 \nEscriba la opcion que desea realizar:");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    Aplicacion.someterArticulo();
                    break;
                case 2:
                    System.out.println("Ingrese su User: ");
                    String user = sc.nextLine();
                    System.out.println("Ingrese su contraseña: ");
                    String contrasenia = sc.nextLine();
                    Aplicacion.iniciarSesion(user, contrasenia);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        }while(opcion!=3);        
        sc.close();
    }
}