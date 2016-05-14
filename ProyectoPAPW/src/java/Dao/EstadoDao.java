/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Estado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arturo
 */
public class EstadoDao {
           
    public static List<Estado> llenaEstado(String Pais) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            List<Estado> ArrEstados = new ArrayList<Estado>();
            cs = connection.prepareCall("{ call Llenar_Estado(" + Pais + ") }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Estado stdo = new Estado(
                        rs.getInt("id"),        //Se Asigna el Valor del Campo 'id' de la Tabla de la BD 
                        //rs.getInt("Pais"),
                        rs.getString("Descripcion"));//Se Asigna el Valor del Campo 'Estado' de la Tabla de la BD
                ArrEstados.add(stdo);
            }
            return ArrEstados;
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
