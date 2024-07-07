package com.pooespol;

public class Revisor extends Persona{
    private String especialidad;
    private String user;
    private String contrasenia;
    private int articulosRevisados;
    

    public Revisor(String nombre, String apellido, String correo,String contraseniaCorreo, Usuario rol, String especialidad, String user,String contrasenia, int articulosRevisados ){
        super(nombre, apellido,correo,rol,contraseniaCorreo);
        this.especialidad = especialidad;
        this.user = user;
        this.contrasenia = contrasenia;
        this.articulosRevisados = articulosRevisados;
    }
    
    public String getEspecialidad(){
        return especialidad;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public String getUser(){
        return user;
    }

    public int getArticulosRevisados(){
        return articulosRevisados;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setArticulosRevisados(int articulosRevisados){
        this.articulosRevisados = articulosRevisados;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass()){
            Revisor revisor2 = (Revisor)obj;
            if((nombre.equals(revisor2.getNombre())) && (apellido.equals(revisor2.getApellido())) && (correo.equals(revisor2.getCorreo())) && (especialidad.equals(revisor2.getEspecialidad())) && (user.equals(revisor2.getUser()))&&(contrasenia.equals(revisor2.getContrasenia()))&& (articulosRevisados==revisor2.getArticulosRevisados())&&(contraseniaCorreo.equals(revisor2.getcontraseniaCorreo())))
                return true;
        }
        return false;    
    }
    

    
}
