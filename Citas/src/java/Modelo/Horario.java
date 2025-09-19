package Modelo;

import java.util.Date;

public class Horario {
    
    private int IdHorario;      
    private Date HoraInicio;    
    private Date HoraFin;       
    

    // Constructor con todos los atributos
    public Horario(int IdHorario, Date HoraInicio, Date HoraFin) {
        this.IdHorario = IdHorario;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
    }

    // Getters y Setters
    public int getIdHorario() { 
        return IdHorario; 
    }
    public void setIdHorario(int IdHorario) { 
        this.IdHorario = IdHorario; 
    }

    public Date getHoraInicio() { 
        return HoraInicio; 
    }
    public void setHoraInicio(Date HoraInicio) { 
        this.HoraInicio = HoraInicio; 
    }

    public Date getHoraFin() { 
        return HoraFin; 
    }
    public void setHoraFin(Date HoraFin) { 
        this.HoraFin = HoraFin; 
    }
}
