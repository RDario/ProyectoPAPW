/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Pais;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arturo
 */
public class PaisDao {
    
    public static List<Pais> llenaPais() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            List<Pais> piss = new ArrayList<Pais>();
            cs = connection.prepareCall("{ call Llenar_Pais() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Pais depto = new Pais(
                        rs.getInt("id"),        //Se Asigna el Valor del Campo 'id' de la Tabla de la BD 
                        rs.getString("Descripcion"));//Se Asigna el Valor del Campo 'Estado' de la Tabla de la BD
                piss.add(depto);
            }
            return piss;
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
