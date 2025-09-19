package Modelo;

public class Empleado {
    
    private String Nombres, Apellidos, Correo, Telefono;
    private int idEmpleado;
    
public Empleado(String Nombres, String Apellidos, String Correo, String Telefono, int idEmpleado)
{
    this.Nombres = Nombres;
    this.Apellidos = Apellidos;
    this.Correo = Correo;
    this.Telefono = Telefono;
    this.idEmpleado = idEmpleado;
}

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


}