/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Beans.Categoria;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Arturo
 */
public class CategoriaDao {
    //Modificar_C
    
    public static Categoria EliminaSc(int idSubCategoria, int idCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Elimina_Sc(?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, idSubCategoria);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setInt(2, idCategoria);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            
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
    
    public static Categoria ModificarS(int idSubCategoria, String NSubCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Modificar_S(?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, idSubCategoria);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setString(2, NSubCategoria);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            
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
    
    public static Categoria ModificarC(int Categoria, String NCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Modificar_C(?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, Categoria);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setString(2, NCategoria);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            
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
    
     public static Categoria AgregaS(int Categoria, String SubCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Agregar_S(?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setInt(1, Categoria);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setString(2, SubCategoria);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            
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
    
     public static Categoria AgregaCS(String Categoria, String SubCategoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Agregar_CS(?, ?) }");//Se Llama a el SP 'PreRegistro'
            cs.setString(1, Categoria);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setString(2, SubCategoria);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            
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
