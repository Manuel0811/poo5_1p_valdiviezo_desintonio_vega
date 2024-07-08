package com.pooespol;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Usuario rol;
    protected String contraseniaCorreo;

    public Persona(String nombre, String apellido, String correo, Usuario rol,String contraseniaCorreo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = rol;
        this.contraseniaCorreo = contraseniaCorreo;
    }

    /**
     * Este metodo permite mirar el Nombre de la Persona
     * @return Retorna un String del Nombre de la Persona
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Este metodo permite mirar el Apellido de la Persona
     * @return Retornara un String del Apellido de la Persona
     */
    public String getApellido(){
        return apellido;
    }

    /**
     * Este metodo permite mirar el Correo de la Persona
     * @return Retornara el String del Correo de la Persona
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * Este metodo permite mirar el Rol de la Persona
     * @return Retornara el Usuario del Rol de la Persona
     */
    public Usuario getRol(){
        return rol;
    }

    /**
     * Este metodo permite mirar la Contraseña del Correo de la Persona
     * @return Retornara el String de la Contraseña del Correo de la Persona
     */
    public String getcontraseniaCorreo(){
        return contraseniaCorreo;
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

    public void setContraseniaCorreo(String contraseniaCorreo){
        this.contraseniaCorreo = contraseniaCorreo;
    }


}
