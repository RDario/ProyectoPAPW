/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Carlos
 */
public class UsuarioDao {
    
    public static  List<Usuario> LlenaUsuario()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            List<Usuario> ArrUsuario = new ArrayList<Usuario>();
            cs = connection.prepareCall("{ Call Llena_Usuarios() }");//Se Llama a el SP 'Verificar_Reg_Compl'
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            
            while (rs.next())
            {
                Usuario u = new Usuario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Nickname"), 
                                        rs.getString("Correo"), 
                                        rs.getString("Password"), 
                                        rs.getString("Tipo_Usuario"), 
                                        rs.getString("Codigo"), 
                                        rs.getBoolean("Validacion"), 
                                        rs.getString("Foto"), 
                                        rs.getString("Nombre"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getString("Apellido_Pat"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Apellido_Mat"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getString("Nacimiento"),//........
                                        rs.getString("Sexo"),//........
                                        rs.getString("Celular"),//........
                                        rs.getString("Calle"),//........
                                        rs.getString("Numero"),//........
                                        rs.getString("Colonia"),//........
                                        rs.getString("Estado"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                ArrUsuario.add(u);
            }
            return ArrUsuario;
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
    
     public static  Usuario ObtieneUsuario(int Id)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Obtiene_Usuario(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'
            
            cs.setInt(1, Id);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP            
           
            
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            if (rs.next())
            {
                Usuario u = new Usuario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Nickname"), 
                                        rs.getString("Correo"), 
                                        rs.getString("Password"), 
                                        rs.getString("Tipo_Usuario"), 
                                        rs.getString("Codigo"), 
                                        rs.getBoolean("Validacion"), 
                                        rs.getString("Foto"), 
                                        rs.getString("Nombre"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getString("Apellido_Pat"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Apellido_Mat"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getString("Nacimiento"),//........
                                        rs.getString("Sexo"),//........
                                        rs.getString("Celular"),//........
                                        rs.getString("Calle"),//........
                                        rs.getString("Numero"),//........
                                        rs.getString("Colonia"),//........
                                        rs.getString("Estado"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                return u;
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
        //ObtienePerfil::: Se obtiene el Perfil del Usuario
    public static  Usuario ObtienePerfil(String Correo)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Obtiene_Perfil(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'
            
            cs.setString(1, Correo);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP            
           
            
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            if (rs.next())
            {
                Usuario u = new Usuario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Nickname"), 
                                        rs.getString("Correo"), 
                                        rs.getString("Nombre"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 4° PARAMETRO 
                                        rs.getString("Apellido_Pat"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 5° PARAMETRO  
                                        rs.getString("Apellido_Mat"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 6° PARAMETRO 
                                        rs.getString("Nacimiento"),//........
                                        rs.getString("Sexo"),//........
                                        rs.getString("Celular"),//........
                                        rs.getString("Calle"),//........
                                        rs.getString("Numero"),//........
                                        rs.getString("Colonia"),//........
                                        rs.getString("Estado"),//........
                                        rs.getString("Pais"),
                                        rs.getString("Foto"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                return u;
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    //VericarPerfilCompleto::: Se obtiene el Registro con el mismo 'id' que Ingreso el Usuario
    public static  Usuario VericarPerfilCompleto(String id)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Verificar_Reg_Compl(?) }");//Se Llama a el SP 'Verificar_Reg_Compl'
            
            cs.setString(1, id);//Se le Asigna el Valor del PARAMETRO llamado 'id' a el Primer(1) Parametro del SP            
           
            
            rs = cs.executeQuery();    //Se Ejecuta el Query (SP-Verificar_Reg_Compl)
            
            if (rs.next())
            {
                Usuario u = new Usuario(rs.getString("Nombre"), //Se le ASIGNA el Valor del CAMPO 'Nombre' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Apellido_Pat"),//Se le ASIGNA el Valor del CAMPO 'Apellido_Pat' que Resulta de el Query al 2° PARAMETRO  
                                        rs.getString("Apellido_Mat"), //Se le ASIGNA el Valor del CAMPO 'Apellido_Mat' que Resulta de el Query al 3° PARAMETRO 
                                        rs.getString("Nacimiento"),//........
                                        rs.getString("Sexo"),//........
                                        rs.getString("Celular"),//........
                                        rs.getString("Calle"),//........
                                        rs.getString("Numero"),//........
                                        rs.getString("Colonia"),//........
                                        rs.getString("Estado"),//........
                                        rs.getBoolean("Validacion"),
                                        rs.getString("Codigo"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                return u;
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    //VerificaMail::  Verifica que el CORREO que Ingrese el Usuario NO EXISTA
    public static  Usuario VericarMail(String Email)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Verificar_Mail(?) }");//Se Llama a el SP 'Verificar_Mail'
            
            cs.setString(1, Email);//Se le Asigna el Valor del PARAMETRO llamado 'Email' a el Primer(1) Parametro del SP            
           
            
            rs = cs.executeQuery();//Se Ejecuta el Query (SP-Verificar_Mail)
            
            
            if (rs.next())
            {
                Usuario u = new Usuario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Nickname"),//Se le ASIGNA el Valor del CAMPO 'Nickname' que Resulta de el Query al 2° PARAMETRO  
                                        rs.getString("Correo"), //Se le ASIGNA el Valor del CAMPO 'Correo' que Resulta de el Query al 3° PARAMETRO 
                                        rs.getString("Password"),//........
                                        rs.getString("Tipo_Usuario"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                return u;
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    //CompletaPerfil::: Hace un Update con los Datos que ingresa el Usuario
    public static void CompletaPerfil(String ID, String Nombre, String Apellido_Pat, String Apellido_Mat, String Dia, String Mes, String Year, String Sexo, String Telefono, String Calle, String Numero, String Colonia, String Estado, String idFoto)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Completa_Perfil(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");//Se Llama a el SP 'Completa_Perfil'
            
            cs.setString(1, ID);//Se le Asigna el Valor del PARAMETRO llamado 'ID' a el Primer(1) Parametro del SP            
            cs.setString(2, Nombre);//Se le Asigna el Valor del PARAMETRO llamado 'Nombre' a el Segundo(2) Parametro del SP
            cs.setString(3, Apellido_Pat);//....
            cs.setString(4, Apellido_Mat);//.....
            cs.setString(5, (Year + '-' + Mes + '-' + Dia));
            cs.setString(6, Sexo);
            cs.setString(7, Telefono);
            cs.setString(8, Calle);
            cs.setString(9, Numero);
            cs.setString(10, Colonia);
            cs.setString(11, Estado);
            cs.setString(12, idFoto);
            
            cs.execute();     //Se Ejecuta el Query (SP-Completa_Perfil)
        }
        
        catch (Exception ex) 
        {
            ex.printStackTrace();  
        }
        
        finally 
        {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    //Login::: Verifica que Exista el Correo
    public static Usuario Login(String Email, String Password)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call Validar_Login(?, ?) }");//Se Llama a el SP 'Validar_Login'
            
            cs.setString(1, Email);//Se le Asigna el Valor del PARAMETRO llamado 'Email' a el Primer(1) Parametro del SP            
            cs.setString(2, Password);//Se le Asigna el Valor del PARAMETRO llamado 'Password' a el Segundo(2) Parametro del SP
            
            
            rs = cs.executeQuery();     //Se Ejecuta el Query (SP-Validar_Login)
            
            if (rs.next())
            {
                Usuario u = new Usuario(rs.getInt("id"), //Se le ASIGNA el Valor del CAMPO 'id' que Resulta de el Query al 1° PARAMETRO 
                                        rs.getString("Nickname"),//Se le ASIGNA el Valor del CAMPO 'Nickname' que Resulta de el Query al 2° PARAMETRO  
                                        rs.getString("Correo"), //Se le ASIGNA el Valor del CAMPO 'Correo' que Resulta de el Query al 2° PARAMETRO 
                                        rs.getString("Password"),//........
                                        rs.getString("Tipo_Usuario"));//........
                //Aqui se Asingnan los Valores que ARROJA la CONSULTA  
                
                return u;
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
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    //PreRegistro::: Inserta los Datos Ingresados por el Usuario a la Tabla Usuario (*VerificaMail)
    public static Usuario PreRegistro(String NiCk, String Email, String Password, String Rndm)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        
        try
        {
            cs = connection.prepareCall("{ Call PreRegistro(?, ?, ?, " + 2 + ",'" + Rndm +"') }");//Se Llama a el SP 'PreRegistro'
            cs.setString(1, NiCk);     //Se le Asigna el Valor del PARAMETRO llamado 'Nick' a el 1° Parametro del SP   
            cs.setString(2, Email);    //Se le Asigna el Valor del PARAMETRO llamado 'Email' a el 2° Parametro del SP   
            cs.setString(3, Password); //..............
            
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