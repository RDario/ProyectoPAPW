/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Categoria;
import Beans.SubCategoria;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Carlos
 */
public class PaginaDao {
  
    public static List<Categoria> ObtieneCategoria() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try 
        {
            List<Categoria> Cat = new ArrayList<Categoria>();
            cs = connection.prepareCall("{ call Obtiene_Categoria() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Categoria cate;//Se Asigna el Valor del Campo 'Estado' de la Tabla de la BD
                cate = new Categoria(
              rs.getInt("id"),        //Se Asigna el Valor del Campo 'Estado' de la Tabla de la BD
              rs.getString("Descripcion"));
                Cat.add(cate);
            }
            return Cat;
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return null;            
        }
        
        finally 
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static List<SubCategoria> ObtieneSubCategoria(String Categoria)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try 
        {
            List<SubCategoria> Cat = new ArrayList<SubCategoria>();
            cs = connection.prepareCall("{ call Obtiene_SubCategoria(" + Categoria + ") }");
            
            rs = cs.executeQuery();
            while (rs.next()) {
                SubCategoria depto = new SubCategoria(
                        rs.getInt("id"),        //Se Asigna el Valor del Campo 'id' de la Tabla de la BD 
                        rs.getInt("Categoria"), 
                        rs.getString("Descripcion"));//Se Asigna el Valor del Campo 'Estado' de la Tabla de la BD
                Cat.add(depto);
            }
            return Cat;
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return null;            
        }
        
        finally 
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    
}