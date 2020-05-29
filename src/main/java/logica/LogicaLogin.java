/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.faces.context.FacesContext;
import pojo.Admin;

/**
 *
 * @author Eduard Fierro
 */
public class LogicaLogin {
    private String usuario, clave, redirecciona;
    private Admin admin;

    public LogicaLogin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public void loguearse(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Admin adm = (Admin) context.getExternalContext().getSessionMap().get("admin");
        if(adm.getUsuario().equals(usuario) && adm.getClave().equals(clave)){
            this.setRedirecciona("menuAdmin.xhtml");
        }
        else{
            this.setRedirecciona("");
        }
    }
    /*public void LecturaFichero(){
        try{
            File archivo = new File ("Archivos/admin.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            String linea = br.readLine();
            String palabra[] = linea.split(";");
            for(int i=0;i<palabra.length;i++){
                String bufer[] = palabra[i].split(",");
                admin = new Admin(bufer[0], bufer[1]);
            }
        }
        catch(FileNotFoundException e){
             System.out.print("se revento en lectura fichero" );
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }*/
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRedirecciona() {
        return redirecciona;
    }

    public void setRedirecciona(String redirecciona) {
        this.redirecciona = redirecciona;
    }
    
}
