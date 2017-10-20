package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	private ContaDAO contaDao;
	
	@Autowired
	public ContaController(ContaDAO contaDao) {
		this.contaDao = contaDao;

	}
	
	@RequestMapping("form")
	public String formulario(){
		return "conta/formulario";
	}
	
	@RequestMapping(value="adicionarConta")
	public String adiciona(@Valid Conta conta,BindingResult result){
		
		System.out.println(conta.getDataPagamento());
		
		/**
		 * Se tiver qualquer erro, volta pro form
		 */
		if(result.hasErrors())
			return "conta/formulario";
		
		contaDao.adiciona(conta);
		
		return "redirect:lista";
	}
	
	@RequestMapping("/pagaConta")
	public void pagarConta(Conta conta,HttpServletResponse response){
		this.contaDao.paga(conta.getId());
		response.setStatus(200);
	}
	
	@RequestMapping("/mostraConta")
	public String mostra(Long id,Model model){
		
		Conta conta = this.contaDao.buscaPorId(id);
		
		model.addAttribute("conta", conta);
		
		return "conta/mostra";
	}
	
	@RequestMapping("/alteraConta")
	public String alteraConta(Conta conta){
		
		System.out.println(conta.toString());
		
		this.contaDao.altera(conta);
		
		return "redirect:lista";
	}
	
	@RequestMapping(value={"/","/lista"})
	public String lista(Model model){
		
		List<Conta> contas = this.contaDao.lista();
		
		model.addAttribute("contas", contas);
		
		return "conta/lista";
	}
	
	@RequestMapping("removeConta")
	public String excluir(Conta conta){
		
		this.contaDao.remove(this.contaDao.buscaPorId(conta.getId()));
		
		return "redirect:lista";
	}
	
}
