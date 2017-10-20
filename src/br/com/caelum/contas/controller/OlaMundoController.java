package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OlaMundoController {

	@RequestMapping("olaMundoSpring")
	public String action(){
		System.out.println("Samba do Criolo Doido");
		return "LetMoveOn";
	}
	
}
