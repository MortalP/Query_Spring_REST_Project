package fi.bfk.kysely.controller;

import java.util.List;

import javax.inject.Inject;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fi.bfk.kysely.dao.KysymysDAO;
import fi.bfk.kysely.bean.Kysymys;
import fi.bfk.kysely.bean.Vastaus;
import fi.bfk.kysely.bean.VastausKysymykseen;

@Controller
@RequestMapping(value="/kysymykset")
public class KysymysController {
	
	@Inject
	public KysymysDAO dao;
	
	public KysymysDAO getDao(){
		return dao;
	}
	public void setDao(KysymysDAO dao){
		this.dao = dao;
	}
	
	//FORMIN TEKEMINEN
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kysymys tyhjaKysymys = new Kysymys();
		
		model.addAttribute("kysymys", tyhjaKysymys);
		return "kyse/createForm";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="kysymys") @Valid Kysymys kysymys, BindingResult result) {
		if (result.hasErrors()) {
			return "kyse/createForm";
		} else {
			dao.talleta(kysymys);
			return "redirect:/kysymykset/" + kysymys.getId();
		}
	}
	
	
	
	@RequestMapping("kysymykset")
	public String naytaKysymyslista(){
		return "kyse/kysymyslista";
	}
	
	
	//KYSYMYKSEN TIETOJEN NÄYTTÄMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Kysymys kysymys = dao.etsi(id);
		model.addAttribute("kysymys", kysymys);
		return "kyse/view";
	}
	
	//KYSYMYSLISTAN NÄYTTÄMINEN
	@RequestMapping (value="lista", method=RequestMethod.GET)
	public String getDetails(Model model){
		List<Kysymys> kysymykset = dao.haeKaikki();
		model.addAttribute("kysymykset", kysymykset);
		
		Vastaus tyhjaVastaus = new Vastaus();
		model.addAttribute("vastaus", tyhjaVastaus);
		
		return "kyse/lista";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="lista", method=RequestMethod.POST)
	public String createVastaus( @ModelAttribute(value="vastaus") @Valid VastausKysymykseen vastaus, BindingResult result) {
		if (result.hasErrors()) {
			return "kyse/lista";
		} else {
			dao.talletaVastaus(vastaus);
			return "kyse/vastaus";
		}
	}
	
	//VASTAUKSEN TIETOJEN NÄYTTÄMINEN
	@RequestMapping(value="vastaus", method=RequestMethod.GET)
	public String getVastaus(@PathVariable Integer id, Model model) {
		Vastaus vastaus = dao.etsiVastaus(id);
		model.addAttribute("vastaus", vastaus);
		return "kyse/vastaus";
	}

	//VASTAUSLISTAN NÄYTTÄMINEN
	@RequestMapping (value="vastauslista", method=RequestMethod.GET)
	public String getVastaukset(Model model){
		List<VastausKysymykseen> vastaukset = dao.haeKaikkiVastaukset();
		model.addAttribute("vastaukset", vastaukset);
		return "kyse/vastauslista";
	}
}
