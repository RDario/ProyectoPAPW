/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Diego
 */
public class ArchivoDAO {
     public static void insertarVideo(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{ call insertar_video(?, ?, ?) }");
            cs.setString(1, a.getDescripcion());
            cs.setString(2, a.getTipo());
            cs.setString(3, a.getUbicacion());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil2.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static void insertarImagen(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try { 
            cs = connection.prepareCall("{ call insertarImagen(?, ?, ?) }");
           cs.setString(1, a.getDescripcion());
            cs.setString(2, a.getTipo());
            cs.setString(3, a.getUbicacion());
           // cs.setBlob(3, a.getStream());
           // cs.registerOutParameter(4, Types.INTEGER);
            cs.execute();
           // int id = cs.getInt(4);
            //return id;
            
        } catch (Exception ex) {
            ex.printStackTrace();
           
            
        } finally {
            DBUtil2.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static Archivo buscarImagen(int id) 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{call buscarImagen(?)}");
            cs.setInt(1,id);
            rs= cs.executeQuery();
            if(rs.next()){
                Archivo arc;
                arc = new Archivo(
                rs.getInt("idVideo"),
                rs.getString("Descripcion"));
                return arc;
            }
                return null;
            } catch(Exception ex) {
                    ex.printStackTrace();
                    return null;
                    } finally {
                            DBUtil2.closeResultSet(rs);
                            DBUtil2.closeStatement(cs);
                            pool.freeConnection(connection);
                            }
            
        }
    }
    /*
    public static InputStream obtenerImagen(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call obtener_imagen(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getBinaryStream(1);
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil2.closeResultSet(rs);
            DBUtil2.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }*/
    

