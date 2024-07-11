/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MMoralesToDoList.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alien 5
 */
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarea")
    private int IdTarea;

    @Column(name = "titulo")
    private String Titulo;

    @Column(name = "descripcion")
    private String Descripcion;

    @Column(name = "fechavencimiento")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date FechaVencimiento;

    public Tarea() {
    }
    
    @ManyToOne
    @JoinColumn(name="idestatus")
    public Estatus Estatus;

    public Tarea(int IdTarea, String Titulo, String Descripcion, Date FechaVencimiento) {
        this.IdTarea = IdTarea;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.FechaVencimiento = FechaVencimiento;
    }

    public int getIdTarea() {
        return IdTarea;
    }

    public void setIdTarea(int IdTarea) {
        this.IdTarea = IdTarea;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

}
