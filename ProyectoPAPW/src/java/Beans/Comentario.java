/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class Comentario {
    
    private int id;
    private int Usuario;
    private int Producto;
    private String Comentario;
    private String FechaDias;
    private String FechaP;
    private String Respuesta;
    
    public Comentario(int id, int Usuario, int Producto, String Comentario, String FechaDias, String FechaP, String Respuesta)
    {
        this.id = id;
        this.Usuario = Usuario;
        this.Producto = Producto;
        this.Comentario = Comentario;
        this.FechaDias = FechaDias;
        this.FechaP = FechaP;
        this.Respuesta = Respuesta;
    }
    
    public Comentario(int id, int Usuario, int Producto, String Comentario, String FechaP, String Respuesta)
    {
        this.id = id;
        this.Usuario = Usuario;
        this.Producto = Producto;
        this.Comentario = Comentario;
        this.FechaP = FechaP;
        this.Respuesta = Respuesta;
    }

    public int getId() {
        return id;
    }

    public int getUsuario() {
        return Usuario;
    }

    public int getProducto() {
        return Producto;
    }

    public String getComentario() {
        return Comentario;
    }
    
    public String getFechaP() {
        return FechaP;
    }

    public String getFechaDias() {
        return FechaDias;
    }

    public String getRespuesta() {
        return Respuesta;
    }
    
    
    
    
    
}
