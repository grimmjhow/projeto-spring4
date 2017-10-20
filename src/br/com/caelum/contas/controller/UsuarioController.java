package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {
		
	private UsuarioDAO dao = new UsuarioDAO();
	
	@RequestMapping("loginForm")
	public String formulario(){
		return "usuario/login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario,Model model,HttpSession session){
		boolean existeUsuario = this.dao.existeUsuario(usuario);
		
		if(existeUsuario){
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:lista";
		}else{
			return "forward:loginForm";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "redirect:loginForm";
	}
	
}
