/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MMoralesToDoList.DAO;

import MMoralesToDoList.JPA.Result;
import MMoralesToDoList.JPA.Usuario;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Alien 5
 */
@Repository
public interface UsuarioDAO{
    
//    Usuario save(Usuario usuario);
	Result Delete(int IdUsuario);
    Result findAll();
    Result findByUserName(Usuario busquedaUser);
    Result AddUsuario(Usuario usuario);
    Result Update(Usuario usuario);
}
