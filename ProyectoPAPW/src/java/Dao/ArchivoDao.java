/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Archivo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Carlos
 */
public class ArchivoDao {
 
    public static void insertarVideo(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{ call insertar_video(?, ?, ?) }");
            //cs.setString(1, a.getDescripcion());
            cs.setString(2, a.getTipo());
            cs.setString(3, a.getUbicacion());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertarImagen(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try { 
            cs = connection.prepareCall("{ call insertar_imagen( ?, ?, ?) }");
            //cs.setString(1, a.getDescripcion());
            cs.setString(1, a.getTipo());
            cs.setBinaryStream(2, new FileInputStream(a.getStream()), a.getStream().length());
            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            int id = cs.getInt(3);
            return id;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertarImagenUSR(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try { 
            cs = connection.prepareCall("{ call Insertar_ImagenUSR( ?, ?, ?) }");
            //cs.setString(1, a.getDescripcion());
            cs.setString(1, a.getTipo());
            cs.setBinaryStream(2, new FileInputStream(a.getStream()), a.getStream().length());
            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            int id = cs.getInt(3);
            return id;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static InputStream obtenerImagenUSR(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call Obtener_ImagenUSR(?) }");
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
}