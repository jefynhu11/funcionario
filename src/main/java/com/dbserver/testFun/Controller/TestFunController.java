package com.dbserver.testFun.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbserver.testFun.models.TestFunModel;
import com.dbserver.testFun.repositories.TestFunRepository;

@Controller
public class TestFunController {
	
	@Autowired
	TestFunRepository testFunRepository;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("index");
		Iterable<TestFunModel> cadastra = testFunRepository.findAll();
		modelView.addObject("cadastrar", cadastra);
		return modelView;
	}
	
	@PostMapping("/")
	public String novoCadastrar(TestFunModel cadastrar) {
		testFunRepository.save(cadastrar);
		return "redirect:/";
	}
	
	@GetMapping("/apagar/{id}")
	@Transactional
	public String apagarCadastrar(@PathVariable("id") long id) {
		testFunRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarCadastrar(@PathVariable("id") long id) {
		ModelAndView modelView = new ModelAndView("editar");
		Iterable<TestFunModel> cadastra = testFunRepository.findById(id);
		modelView.addObject("cadastrar", cadastra);
		return modelView;
	}
	
	@PostMapping("/editar")
	public String editarCadastrar(TestFunModel cadastrar) {
	    testFunRepository.save(cadastrar);
	    return "redirect:/";
	}
	
}
