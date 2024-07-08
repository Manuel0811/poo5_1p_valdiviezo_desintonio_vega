package com.pooespol;

public class Autor extends Persona{
    private static int CODIGOID;
    private String institucion;
    private String campoInvestigacion;

    public Autor(String nombre, String apellido, String correo,Usuario rol, String institucion, String campoInvestigacion){
        super(nombre,apellido,correo,rol);
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
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Autor){
            Autor autor2 = (Autor)obj;
            if((nombre.equals(autor2.getNombre())) && (apellido.equals(autor2.getApellido())) && (correo.equals(autor2.getCorreo())) && (institucion.equals(autor.getInstitucion())) && (campoInvestigacion.equals(autor.getCampoInvestigacion()))){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public Articulo creaArticulo(Autor autor){

        System.out.println("Ingrese el Codigo ID");
        int codId = sc.nextInt();
      
        System.out.println("Ingrese el Titulo");
        String titulo = sc.nextLine();
       
        System.out.println("Ingrese el Resumen");
        String res =sc.nextLine();
       
        System.out.println("Ingrese el contenido");
        String cont =sc.nextLine();
        
        System.out.println("Ingrese cuantas palabras clave va a insertar");
        int nPalabras = sc.nextInt();
        ArrayList <String> palClaves = new ArrayList<String>();
        for(int i=1;i<=nPalabras;i++){
            System.out.println("Ingrese la palabra clave N° "+i);
            String pal = sc.nextLine();
            palClaves.add(pal);
        }

        Articulo art = new Articulo(codId,titulo,res,cont,palClaves,autor);

        return art;

    }

    public void enviarArticulo(){
        
    }
}
