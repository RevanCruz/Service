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
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alien 5
 */
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private int IdUsuario;
    
    @Column(name="nombre")
    private String Nombre;

    @Column(name="apellido")
    private String Apellido;
    
    @Column(name = "fechavencimiento")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date FechaVencimiento;
    
    @Column(name = "password")
    private String Password;
    
    
    @Column(name="username")
    private String UserName;

    public Usuario() {
    }
    
    

    public Usuario(String password, String userName) {
		Password = password;
		UserName = userName;
	}



	public Usuario(int IdUsuario, String Nombre, String Apellido, Date FechaVencimiento, String Password, String UserName) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaVencimiento = FechaVencimiento;
        this.Password = Password;
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaNacimiento) {
        this.FechaVencimiento = FechaNacimiento;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    
}
