package com.pooespol;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Aplicacion {
    public static ArrayList<Persona> personas;
    public static ArrayList<Articulo> articulos;
    
    
    /**
     * Este metodo agrega las Personas de un .txt a un ArrayList
     * @param usuarios un .txt con todas las personas que acceden al programa
     **/
    public static void agregarPersonas(String usuarios){
        personas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(usuarios);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            
            String linea;
            while ((linea = br.readLine()) != null){
                String[] lin = linea.split(",");
                String nombre = lin[0],apellido = lin[1],correo = lin[2], rol = lin[3];
                if (rol.equals("AUTOR")){
                    Usuario rol1 = Usuario.valueOf(rol);
                    String institucion = lin[4], campoInvestigacion = lin[5];
                    Autor autor = new Autor(nombre, apellido, correo, rol1, institucion, campoInvestigacion);
                    personas.add(autor);
                } else if (rol.equals("REVISOR")){
                    Usuario rol1 = Usuario.valueOf(rol);
                    String especialidad = lin[4], user=lin[5], contrasenia= lin[6], articulosRevisados =lin[7];
                    int articulosR= Integer.parseInt(articulosRevisados);
                    Revisor revisor = new Revisor(nombre, apellido, correo, rol1, especialidad, user, contrasenia,articulosR);               
                    personas.add(revisor);
                }else if(rol.equals("EDITOR")){
                    Usuario rol1 = Usuario.valueOf(rol);
                    String nombreJournal = lin[4], user = lin[5], contrasenia = lin[6];
                    Editor editor = new Editor(nombre, apellido, correo, nombreJournal, contrasenia, user, rol1);
                    personas.add(editor);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if (null != fr){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }

    /**
     * Este metodo permite iniciar sesion a un Editor o Revisor
     * @param user Con este usuario accede al programa y se lo busca
     * @param contrasenia Con esta contraseña accede al programa y se lo busca
     */
    public static void iniciarSesion(String user, String contrasenia){
        boolean usuarioEncontrado = false;
        System.out.println("///////////////////////////////////////////////////////////////////////////////"); 
        for (Persona e: personas){
            if(e instanceof Revisor){
                Revisor revi= (Revisor)e;
                if((user.equals(revi.getUser())) && (contrasenia.equals(revi.getContrasenia()))){
                    usuarioEncontrado = true;
                    System.out.println("Revision de articulo");
                    String linea = revi.getNombre() +","+ revi.getApellido()+","+ revi.getCorreo()+","+revi.getRol()+","+revi.getEspecialidad()+","+revi.getUser()+","+ revi.getContrasenia()+","+revi.getArticulosRevisados();
                    guardarDatos("revisores", linea);
                    revi.validarArticulo();
                }
            }else if(e instanceof Editor){
                Editor edi = (Editor)e;
                if((user.equals(edi.getUser())) && (contrasenia.equals(edi.getContrasenia()))){
                    usuarioEncontrado = true;
                    System.out.println("///////////////////////////////////////////////////////////////////////////////");
                    System.out.println("Registro de decision final sobre el articulo");
                    String linea = edi.getNombre()+","+edi.getApellido()+","+edi.getCorreo()+","+edi.getRol()+","+edi.getJournal()+","+edi.getUser()+","+edi.getContrasenia();
                    guardarDatos("editores", linea);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////");
                    edi.decisionFinal();
                }
            }
        }
        if(!usuarioEncontrado){
            System.out.println("Usuario o contraseña invalida");
        }

    }

    /**
     * Este metodo permite al Autor registrar sus datos, los datos de su articulo y someterlo a revision
     */
    public static void someterArticulo(){
        Scanner sc = new Scanner(System.in);
        Usuario rol = Usuario.valueOf("AUTOR");
        System.out.println("///////////////////////////////////////////////////////////////////////////////");
        System.out.println("Ingrese su nombre;");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido;");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su correo;");
        String correo = sc.nextLine();
        System.out.println("Ingrese su institucion;");
        String institucion = sc.nextLine();
        System.out.println("Ingrese su campo de investicacion;");
        String campoInvestigacion = sc.nextLine();
        String linea = nombre+","+apellido+","+correo+","+rol+","+institucion+","+campoInvestigacion;
        guardarDatos("autores", linea);
        Autor autor2 = new Autor(nombre, apellido, correo, rol, institucion, campoInvestigacion);
        System.out.println("///////////////////////////////////////////////////////////////////////////////");
        autor2.enviarArticulo();

    }

    /**
     * Este metodo guarda los datos en una archivo .txt
     * @param nombreArchivo El nombre del archivo .txt donde se guardaran los datos
     * @param linea Los datos que se desean guardar
     */
    public static void guardarDatos(String nombreArchivo,String linea){
        FileWriter fichero = null;
        BufferedWriter bw = null;

        try{
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");

        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(null != fichero){
                    bw.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    /**
     * Este metodo permite enviar correos
     * @param p1 La persona (Autor,Reviro o Editor) que desea enviar el correo
     * @param p2 La persona (Autor,Reviro o Editor) que recibe el correo
     * @param asunto El asunto del cual tratara el correo
     * @param articulo El articulo que sera enviado
     */
    public static void enviarCorreos(Persona p1, Persona p2,String asunto, Articulo articulo){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust","smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String contrasenia = "antd iwne zsqf hmji";
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(p1.getCorreo(),contrasenia);
            }
        });

        try{
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(p2.getCorreo()));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(p2.getCorreo()));
            mensaje.setSubject(asunto);
            mensaje.setText(articulo.toString());
            Transport.send(mensaje);
            System.out.println("Mensaje enviado");
        }catch (MessagingException e){
            
        }
        
    }
}

