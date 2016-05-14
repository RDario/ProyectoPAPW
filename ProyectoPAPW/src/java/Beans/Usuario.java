/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Arturo
 */
public class Usuario {
    

    private int id;
    private String Nickname;
    private String Email;
    private String Pass;
    private String Code;
    
    
    private String Nombre;
    private String Apellido_Pat;
    private String Apellido_Mat;
    private String Dia;
    private String Mes;
    private String Year;
    private String Sexo;
    private String Telefono;
    private String Calle;
    private String Numero;
    private String Colonia;
    private String Estado;
    
    private String Nacimiento;
    private String Pais;
    private boolean Validacion;
    
    private String Tipo_Usuario;
    private String Foto;
    
    
    
    
    public Usuario(int id, String Nickname, String Email, String Pass, String Tipo_Usuario)
    {        
        this.id = id;
        this.Nickname = Nickname;
        this.Email = Email;        
        this.Pass = Pass;
        this.Tipo_Usuario = Tipo_Usuario;
    }
    
    public Usuario(String Nombre, String Apellido_Pat, String Apellido_Mat, String Dia, String Mes, String Year, 
            String Sexo, String Telefono, String Calle, String Numero, String Colonia, String Estado)
    {   
        this.Nombre = Nombre;
        this.Apellido_Pat = Apellido_Pat;
        this.Apellido_Mat = Apellido_Mat;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Year = Year;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.Estado = Estado;
        
    }
    
    public Usuario(String Nombre, String Apellido_Pat, String Apellido_Mat, String Nacimiento,
            String Sexo, String Telefono, String Calle, String Numero, String Colonia, String Estado, boolean Validacion, String Code)
    {   
        this.Nombre = Nombre;
        this.Apellido_Pat = Apellido_Pat;
        this.Apellido_Mat = Apellido_Mat;
        this.Nacimiento = Nacimiento;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.Estado = Estado; 
        this.Validacion = Validacion;
        this.Code = Code;
    }
    
    public Usuario(int id, String Nickname, String Email, String Nombre, String Apellido_Pat, String Apellido_Mat, String Nacimiento,
            String Sexo, String Telefono, String Calle, String Numero, String Colonia, String Estado, String Pais, String Foto)
    {
        this.id = id;
        this.Nickname = Nickname;
        this.Email = Email;
        this.Nombre = Nombre;
        this.Apellido_Pat = Apellido_Pat;
        this.Apellido_Mat = Apellido_Mat;
        this.Nacimiento = Nacimiento;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.Estado = Estado;
        this.Pais = Pais;
        this.Foto = Foto;
    }
    
    //Completo__________________________________________________________________
    //
    public Usuario(int id, String Nickname, String Email, String Pass, String Tipo_Usuario, String Codigo, boolean Validacion, String Foto, String Nombre, String Apellido_Pat, String Apellido_Mat, String Nacimiento,
            String Sexo, String Telefono, String Calle, String Numero, String Colonia, String Estado)
    {
        this.id = id;
        this.Nickname = Nickname;
        this.Email = Email;
        this.Pass=Pass;
        this.Tipo_Usuario = Tipo_Usuario;
        this.Code = Codigo;
        this.Validacion = Validacion;
        this.Foto = Foto;        
        this.Nombre = Nombre;
        this.Apellido_Pat = Apellido_Pat;
        this.Apellido_Mat = Apellido_Mat;
        this.Nacimiento = Nacimiento;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.Estado = Estado;
    }


  

    public int getId() {
        return id;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPass() {
        return Pass;
    }   

    public String getNombre() {
        return Nombre;
    }

    public String getApellido_Pat() {
        return Apellido_Pat;
    }

    public String getApellido_Mat() {
        return Apellido_Mat;
    }

    public String getDia() {
        return Dia;
    }

    public String getMes() {
        return Mes;
    }

    public String getYear() {
        return Year;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCalle() {
        return Calle;
    }

    public String getNumero() {
        return Numero;
    }

    public String getColonia() {
        return Colonia;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCode() {
        return Code;
    }

    
    
    public String getNacimiento() {
        return Nacimiento;
    }

    public boolean isValidacion() {
        return Validacion;
    }

    public String getPais() {
        return Pais;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public String getFoto() {
        return Foto;
    }
    
    
    
    
    
    
}
