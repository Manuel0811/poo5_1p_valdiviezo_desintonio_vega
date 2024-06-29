package com.pooespol;

public class Autor extends Persona{
    private static int CODIGOID;
    private String institucion;
    private String campoInvestigacion;

    public Autor(String nombre, String apellido, String correo, String institucion, String campoInvestigacion){
        super(nombre,apellido,correo);
        this.institucion = institucion;
        this.campoInvestigacion = campoInvestigacion;
        CODIGOID++;
    }

    public String getInstitucion(){
        return institucion;
    }

    public String getCampoInvestigacion(){
        return campoInvestigacion;
    }

    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }

    public void setCampoInvestigacion(String campoInvestigacion){
        this.campoInvestigacion= campoInvestigacion;
    }
    
}
