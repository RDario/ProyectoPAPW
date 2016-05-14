/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Carlos
 */
public class ProductoDao {
    
    public static List<Producto> ProductosUsuarioCOMPRADOS(int Usuario)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Obtiene_Productos_Comprados("+ Usuario +") }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            //cs.setInt(1, Usuario);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(p);
                
                
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
    
    public static Producto ProductoCOMPRADO(int Usuario, int Producto)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Agrega_Compra(?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, Usuario);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setInt(2, Producto);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
           
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
    
    
    public static List<Producto> BusquedaProductos(int Vendedor, int Mes, int Año, int Precio, String Texto)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Busqueda(?, ?, ?, ?, ?) }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            cs.setInt(1, Vendedor);     
            cs.setInt(2, Mes);     
            cs.setInt(3, Año);     
            cs.setInt(4, Precio);     
            cs.setString(5, Texto);     
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(p);
                
                
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
    
    public static List<Producto> ProductosSubCategoria(int idSubCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Productos_SubCategoria(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            cs.setInt(1, idSubCategoria);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(p);
                
                
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
    
    public static List<Producto> ProductosCategoria(int idCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Productos_Categoria(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            cs.setInt(1, idCategoria);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(p);
                
                
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
    
    
    public static Producto ObtieneProductoV(int idProducto)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Obtiene_ProductoV(?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, idProducto); 
            
            rs= cs.executeQuery();     //Se Ejecuta el Query (SP-PreRegistro)  
            
            if (rs.next())
            {
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                return p;
            }
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

    //PreRegistro::: Inserta los Datos Ingresados por el Usuario a la Tabla Usuario (*VerificaMail)
    public static Producto CreaProducto(String Titulo, String Descripcion, String Precio, String Foto, String Usuario, String SubCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Crea_Producto(?, ?, ?, ?, ?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setString(1, Titulo);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setString(2, Descripcion);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            cs.setString(3, Precio); //..............
            cs.setString(4, Foto); //..............
            cs.setString(5, Usuario); //..............
            cs.setString(6, SubCategoria); //..............
            
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
    
     //PreRegistro::: Inserta los Datos Ingresados por el Usuario a la Tabla Usuario (*VerificaMail)
    public static List<Producto> ProductosUsuario(int Usuario)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Obtiene_Productos("+ Usuario +") }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            //cs.setInt(1, Usuario);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(p);
                
                
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
    
    //Obtiene_ProductosTds
    public static List<Producto> ProductosTodos()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
               
        try
        {
            List<Producto> ArrProductos = new ArrayList<Producto>();
            cs = connection.prepareCall("{ Call Obtiene_ProductosTds() }");//Se Llama a el SP 'Verificar_Reg_Compl'            
            //cs.setInt(1, Usuario);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP           
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            while (rs.next())
            {//id, Titulo, Descripcion, Precio, Foto1, Fecha_Publicacion, Usuario, SubCategoria
                Producto p = new Producto(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Titulo"), 
                                        rs.getString("Descripcion"), 
                                        rs.getString("Precio"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getInt("Foto1"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Fecha_Publicacion"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getInt("Usuario"),//........
                                        rs.getInt("SubCategoria"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                ArrProductos.add(p);
                
                
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
    
    
}