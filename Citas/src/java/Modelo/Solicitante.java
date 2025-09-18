package Modelo;

public class Solicitante {
    
    private String Nombres, Apellidos, Correo, Telefono;
    private int idSolicitante;
    
public Solicitante (String Nombres, String Apellidos, String Correo, String Telefono, int idSolicitante)
{
    this.Nombres = Nombres;
    this.Apellidos = Apellidos;
    this.Correo = Correo;
    this.Telefono = Telefono;
    this.idSolicitante = idSolicitante;
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

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }
}