package modelos;

/**
 *
 * @author Dario
 */

public class ModelUsuario {
    private String _nickname;
    private String _nombre;
    private String _apellidos;
    private String _email;
    private String _contrasenia;
    private String _fechaNacimiento;
    private String _genero;
    private String _domicilioCalle;
    private String _domicilioEstado;
    private String _domicilioMunicipio;
    private String _codigoPostal;
    
    public ModelUsuario(String nickname, 
            String nombre, 
            String apellidos, 
            String email, 
            String contrasenia, 
            String fechaNacimiento,
            String genero, 
            String domicilioCalle,
            String domicilioEstado,
            String domicilioMunicipio,
            String codigoPostal){
        this._nickname = nickname;
        this._nombre = nombre;
        this._apellidos = apellidos;
        this._email = email;
        this._contrasenia = contrasenia;
        this._fechaNacimiento = fechaNacimiento;
        this._genero = genero;
        this._domicilioCalle = domicilioCalle;
        this._domicilioEstado = domicilioEstado;
        this._domicilioMunicipio = domicilioMunicipio;
        this._codigoPostal = codigoPostal;
    }

    public String getNickname() {
        return _nickname;
    }
    
    public void setNickname(String _nickname) {
        this._nickname = _nickname;
    }
    
    public String getNombre() {
        return _nombre;
    }
    
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getEmail() {
        return _email;
    }
    
    public void setEmail(String email) {
        this._email = email;
    }
    
    public String getContrasenia() {
        return _contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this._contrasenia = contrasenia;
    }

    public String getFechaNacimiento() {
        return _fechaNacimiento;
    }

    public void setFechaNacimiento(String _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }

    public String getGenero() {
        return _genero;
    }

    public void setGenero(String _genero) {
        this._genero = _genero;
    }

    public String getDomicilioCalle() {
        return _domicilioCalle;
    }

    public void setDomicilioCalle(String _domicilioCalle) {
        this._domicilioCalle = _domicilioCalle;
    }

    public String getDomicilioEstado() {
        return _domicilioEstado;
    }

    public void setDomicilioEstado(String _domicilioEstado) {
        this._domicilioEstado = _domicilioEstado;
    }

    public String getDomicilioMunicipio() {
        return _domicilioMunicipio;
    }

    public void setDomicilioMunicipio(String _domicilioMunicipio) {
        this._domicilioMunicipio = _domicilioMunicipio;
    }

    public String getCodigoPostal() {
        return _codigoPostal;
    }

    public void setCodigoPostal(String _codigoPostal) {
        this._codigoPostal = _codigoPostal;
    }

    public String getApellidos() {
        return _apellidos;
    }

    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }
}
