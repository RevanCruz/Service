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

/**
 *
 * @author Administrador
 */
@Entity
public class Estatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idstatus")
    private int IdEstatus;
    
    @Column(name="estatus")
    private String Estatus;

    public int getIdEstatus() {
        return IdEstatus;
    }

    public void setIdEstatus(int IdEstatus) {
        this.IdEstatus = IdEstatus;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }
    
    
}
