/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MMoralesToDoList.Controller;


import MMoralesToDoList.DAO.UsuarioDAOImplementation;
import MMoralesToDoList.JPA.Result;
import MMoralesToDoList.JPA.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alien 5
 */
@RestController
@RequestMapping("/api")
public class UsuarioController {
    
	@Autowired
	public UsuarioDAOImplementation ususarioDAOImplementation;
	
//	@GetMapping("/login")
//	@ResponseBody
//	public String Login() {
//		return "";
//	}
	
	@ResponseBody
	@PostMapping("/login")
	public Result Login(@RequestBody Usuario usuario) {
		Result result = ususarioDAOImplementation.findByUserName(usuario);
		return result;
	}    
	
	@PostMapping("/addUsuario")
	@ResponseBody
	public Result AddUsuario(@RequestBody Usuario usuario) {
		Result result = ususarioDAOImplementation.AddUsuario(usuario);
		return result;
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public Result GetAll() {
		Result result= ususarioDAOImplementation.findAll();
		return result;
	}

	@PostMapping("/delete")
	@ResponseBody
	public Result Delete(@RequestParam int IdUsuario) {
		Result result=ususarioDAOImplementation.Delete(IdUsuario);
		return result;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public Result Update(@RequestBody Usuario usuario) {
		Result result=ususarioDAOImplementation.Update(usuario);
		return result;
	}
}
