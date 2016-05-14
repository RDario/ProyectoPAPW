/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class Categoria {
    

    private int id;
    private String Descripcion;
    
    
    
    
    public Categoria(int id, String Descripcion)
    {        
        this.id = id;
        this.Descripcion = Descripcion;
        
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return Descripcion;
    }
    
    
    
    
    
    
    
    
}
