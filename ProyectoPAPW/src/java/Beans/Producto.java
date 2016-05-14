/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class Producto {
    

    private int id;
    private String Titulo;
    private String Descripcion;
    private String Precio;
    private int Foto1;
    
    
    private int Video1;
    
    private String FechaPublicacion;
    private int Usuario;
    private int SubCategoria;
    
    
    
    private int Comentarios; 
    
    
    
    
   
    
    
    public Producto(int id, String Titulo, String Descripcion, String Precio, int Foto1, /*int Video1,*/ String FechaPublicacion, int Usuario, int SubCategoria)
    {        
        this.id = id;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Foto1 = Foto1;
        //this.Video1 = Video1;
        this.FechaPublicacion = FechaPublicacion;
        this.Usuario = Usuario;
        this.SubCategoria = SubCategoria;
    }
//Se usa para la Parte de 'COMENTARIOS'
    public Producto(int id, String Titulo, String Descripcion, String Precio, int Foto1, /*int Video1,*/ String FechaPublicacion, int Usuario, int SubCategoria, int Comentarios)
    {        
        this.id = id;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Foto1 = Foto1;
        //this.Video1 = Video1;
        this.FechaPublicacion = FechaPublicacion;
        this.Usuario = Usuario;
        this.SubCategoria = SubCategoria;
        this.Comentarios = Comentarios;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public int getFoto1() {
        return Foto1;
    }

    public int getVideo1() {
        return Video1;
    }

    public String getFechaPublicacion() {
        return FechaPublicacion;
    }

    public int getUsuario() {
        return Usuario;
    }

    public int getSubCategoria() {
        return SubCategoria;
    }

    public int getComentarios() {
        return Comentarios;
    }
    
  
    
    
    
    
}
