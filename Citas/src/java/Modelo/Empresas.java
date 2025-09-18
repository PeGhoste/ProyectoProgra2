package Modelo;

public class Empresas {
    
    private String Nombre, Descripcion;
    private int idEmpresa;
    
public Empresas(String Nombre, String Descripcion, int idEmpresa)
{
    this.Nombre = Nombre;
    this.Descripcion = Descripcion;
}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
}