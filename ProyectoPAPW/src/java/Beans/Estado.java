/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class Estado {
    
    private int id;
    //private int Pais;
    private String Estado;
    
    public Estado(int id, /*int Pais,*/ String Estado)
    {
        this.id = id;
        //this.Pais = Pais;
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    /*public int getPais() {
        return Pais;
    }*/

    public String getEstado() {
        return Estado;
    }
    
    
    
    
    
}
