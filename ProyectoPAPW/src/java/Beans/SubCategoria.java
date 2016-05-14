/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class SubCategoria {
    

    private int id;
    private String Descripcion;
    private int Categoria;
    
    
    
    public SubCategoria(int id, int Categoria, String Descripcion)
    {        
        this.id = id;
        this.Categoria = Categoria;
        this.Descripcion = Descripcion;
        
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getCategoria() {
        return Categoria;
    }
    
    
    
    
    
    
    
    
}
