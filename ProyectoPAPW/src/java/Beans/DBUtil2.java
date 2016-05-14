/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class DBUtil2 {
     public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
