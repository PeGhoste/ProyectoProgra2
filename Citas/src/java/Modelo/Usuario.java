package Modelo;

public class Usuario {
    
    private int IdUsuario;
    private String Username;
    private String Pass;
    private int FK_IdEmpleado; // clave foránea que referencia a Empleado



    // Constructor con todos los atributos
    public Usuario(int IdUsuario, String Username, String Pass, int FK_IdEmpleado) {
        this.IdUsuario = IdUsuario;
        this.Username = Username;
        this.Pass = Pass;
        this.FK_IdEmpleado = FK_IdEmpleado;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getFK_IdEmpleado() {
        return FK_IdEmpleado;
    }

    public void setFK_IdEmpleado(int FK_IdEmpleado) {
        this.FK_IdEmpleado = FK_IdEmpleado;
    }
}
