/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Comentario;
import Beans.Producto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arturo
 */
public class ComentarioDao {
    //Respuesta_Comentario
    
    public static Comentario AdminEliminaComent(int idComentario)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Elimina_Comentario(?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, idComentario);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            
            cs.execute();     //Se Ejecuta el Query (SP-PreRegistro)            
            
            return null;
        }
        
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
            
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Comentario> AdminBComentarios(String Texto)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Comentario> ArrComentarios = new ArrayList<Comentario>();
            cs = connection.prepareCall("{ Call Busca_Comentarios(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            cs.setString(1, Texto);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Comentario comnt = new Comentario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getInt("Usuario"), 
                                        rs.getInt("Producto"), 
                                        rs.getString("Comentario"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getString("Fecha_Pub"),//........
                                        rs.getString("Respuesta"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrComentarios.add(comnt);
                
                
            }
            return ArrComentarios;
            
        }
        
        catch (Exception ex)
        {
            ex.printStackTrace();            
            return null;
            
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static String RespuestaComentario(String ID, String Respuesta)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Respuesta_Comentario(?, ?) }");//Se Llama a el SP 'Completa_Perfil'
            
            cs.setString(1, ID);//Se le Asigna el Valor del PARAMETRO llamado 'ID' a el Primer(1) Parametro del SP            
            cs.setString(2, Respuesta);//Se le Asigna el Valor del PARAMETRO llamado 'Nombre' a el Segundo(2) Parametro del SP
            
            
            cs.execute();     //Se Ejecuta el Query (SP-Completa_Perfil)
            return "Hola";
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
            return "Hola";
        }
    }
    
    
    
    public static List<Producto> ComentariosOrderByProducto(int Usuario)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Obtiene_ComentarioOrByP("+ Usuario +") }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            //cs.setInt(1, Usuario);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto comnt = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"),
                                        rs.getInt("Comentarios"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(comnt);
                
                
            }
            return ArrProductos;
            
        }
        
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
            
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Comentario> ComentariosProducto(int Producto)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Comentario> ArrComentarios = new ArrayList<Comentario>();
            cs = connection.prepareCall("{ Call Obtiene_ComentariosP(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            cs.setInt(1, Producto);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Comentario comnt = new Comentario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getInt("Usuario"), 
                                        rs.getInt("Producto"), 
                                        rs.getString("Comentario"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getString("Fecha"),
                                        rs.getString("Fecha_Pub"),//........
                                        rs.getString("Respuesta"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrComentarios.add(comnt);
                
                
            }
            return ArrComentarios;
            
        }
        
        catch (Exception ex)
        {
            ex.printStackTrace();            
            return null;
            
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static Comentario CreaComentario(String Usuario, String Producto, String Comentario)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Crea_Comentario(?, ?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setString(1, Usuario);     //Se le Asigna el Valor del PARAMETRO llamado 'Usuario' a el 1° Parametro del SP   
            cs.setString(2, Producto);    //Se le Asigna el Valor del PARAMETRO llamado 'Producto' a el 2° Parametro del SP   
            cs.setString(3, Comentario); //..............
            
            cs.execute();     //Se Ejecuta el Query (SP-PreRegistro)            
            
            return null;
        }
        
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
            
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    
}
