package br.com.financeiro.controlefinanceiro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.financeiro.controlefinanceiro.dao.FinanceiroDAO;
import br.com.financeiro.controlefinanceiro.model.Financeiro;

@Controller
public class FinanceiroController {
	
	@Autowired // Data Access Object injection
	private FinanceiroDAO financeiroDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("Exibindo a home");
		List<Financeiro> financas = financeiroDAO.listar();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("financas", financas); //return and send list to "home.jsp"
		return modelAndView;
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Financeiro> home() {
//		System.out.println("Exibindo a home");
//		return financeiroDAO.listar();
//	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String form() {
		return "/form";
	}
	//Access "formulário"
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(Financeiro financa, RedirectAttributes redirectAttributes) {
		financeiroDAO.salvar(financa);
		redirectAttributes.addFlashAttribute("sucesso", "Movimentação cadastrada com sucesso");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") Integer id) {
		System.out.println("acessando controller de delete, id: " + id);
		financeiroDAO.remover(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		System.out.println("acessando controller de editar");
		ModelAndView mav = new ModelAndView("editform");
		Financeiro financa = financeiroDAO.getFinanceiroById(id);
		mav.addObject("financa", financa);
		return mav;
	}

	@RequestMapping(value ="/editar/salvar", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("financa") Financeiro financa) {
		System.out.println("Entrou no controller de atualizar");
	    financeiroDAO.editar(financa);
	    return "redirect:/" ;
	}

}
