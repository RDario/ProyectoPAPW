/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class Pais {
    
    private int id;
    private String Pais;
    
    public Pais(int id, String Pais)
    {
        this.id = id;
        this.Pais = Pais;        
    }

    public int getId() {
        return id;
    }

    public String getPais() {
        return Pais;
    }
    
    
    
}
