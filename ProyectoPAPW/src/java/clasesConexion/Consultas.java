/**
 *
 * @author Dario
 */
package clasesConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultas extends ConexionDataBase {

    public Consultas() {
        super();
    }

    public static boolean autenticarUsuario(String usuario, String contrasenia) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ConexionDataBase conexionDataBase = new ConexionDataBase();
        String consulta = "SELECT * FROM usuario WHERE nicknameUsuario = ? AND contraseniaUsuario = ?";
        try {
            if (getConnection() != null) {
                preparedStatement = getConnection().prepareStatement(consulta);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, contrasenia);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.absolute(1)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (getConnection() != null) {
                try {
                    getConnection().close();
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static LinkedList<String> obtenerDatosUsuario(String usuario, String contrasenia) {
        LinkedList<String> datos = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String consulta = "SELECT * FROM usuario WHERE nicknameUsuario = ? AND contraseniaUsuario = ?";
        try {
            preparedStatement = getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasenia);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                datos.add(resultSet.getString(2));
                datos.add(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (getConnection() != null) {
                try {
                    getConnection().close();
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return datos;
    }

    public static boolean altaUsuario(String nickname, String nombre, String apellidos, String email,
            String contrasenia, String fechaNacimiento, String genero, String domicilioCalle,
            String municipio, String estado, String codigoPostal) {
        try {
            ConexionDataBase conexionDataBase = new ConexionDataBase();
            PreparedStatement preparedStatement = null;
            String consulta = "INSERT INTO usuario (nicknameUsuario, nombreUsuario, apellidosUsuario, emailUsuario, contraseniaUsuario, fechaNacimientoUsuario, generoUsuario, domicilioCalle, domicilioMunicipio, domicilioEstado, domicilioCodigoPostal) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellidos);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, contrasenia);
            preparedStatement.setString(6, fechaNacimiento);
            preparedStatement.setString(7, genero);
            preparedStatement.setString(8, domicilioCalle);
            preparedStatement.setString(9, municipio);
            preparedStatement.setString(10, estado);
            preparedStatement.setString(11, codigoPostal);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            } else {
                getConnection().close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, "---------EXCEPTION------------> ", ex);
        } finally {
            if (getConnection() != null) {
                try {
                    getConnection().close();
                } catch (SQLException ex) {
                    Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}