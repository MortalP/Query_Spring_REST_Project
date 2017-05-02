package fi.bfk.kysely.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fi.bfk.kysely.bean.Kysymys;
import fi.bfk.kysely.bean.Vastaus;
import fi.bfk.kysely.bean.VastausKysymykseen;
import fi.bfk.kysely.dao.KysymysDAO;

@RestController


public class KysymysRestController {
	
	@Inject
	public KysymysDAO dao;
	
	public KysymysDAO getDao(){
		return dao;
	}
	public void setDao(KysymysDAO dao){
		this.dao = dao;
	}
	
	
	//lis‰‰ kysymys
	@RequestMapping(value="/rest/", method=RequestMethod.POST)
	public ResponseEntity <Kysymys> talleta(@RequestBody Kysymys k) {
		dao.talleta(k);
		
        return new ResponseEntity<Kysymys>(k, HttpStatus.OK);
		
	}
	
	//etsi kaikki kysymykset
	@RequestMapping(value="/rest/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity <List<Kysymys>> haeKysymyksetJSON() {
		List<Kysymys> kysymykset = dao.haeKaikki();
		
		return new ResponseEntity <List<Kysymys>>(kysymykset, HttpStatus.OK);
		
	}

	
	
	//etsi yksitt‰inen kysymys
	@RequestMapping(value = "/rest/{id}", method=RequestMethod.GET)
	public ResponseEntity<Kysymys> haeKaikki(@PathVariable("id") int id){
		Kysymys kysymys = dao.etsi(id);
		
		return new ResponseEntity<Kysymys>(kysymys, HttpStatus.OK);
	}
	
	
	//poista kysymys
	/*
	@RequestMapping(value = "/rest/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Kysymys> poista(@PathVariable("id")int id){
	Kysymys kysymys = dao.etsi(id);
	
	dao.poistaKysymysById(id);
	return new ResponseEntity<Kysymys>(HttpStatus.NO_CONTENT);
	}*/
	
	//muokkaa kysymyst‰
	/*
	@RequestMapping(value = "/rest/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Kysymys> update(@PathVariable("id")int id, @RequestBody Kysymys kysymys){
		Kysymys nykyinenKysymys = null; dao.etsi(id);
		nykyinenKysymys.setKysymys(kysymys.getKysymys());
		return new ResponseEntity<Kysymys>(nykyinenKysymys, HttpStatus.OK);
	}*/
	
	//lis‰‰ vastaus
		@RequestMapping(value="/rest/v/", method=RequestMethod.POST)
		public ResponseEntity <Vastaus> talleta(@RequestBody Vastaus v) {
			dao.talletaVastaus(v);
			
	        return new ResponseEntity<Vastaus>(v, HttpStatus.OK);
			
		}
		
		//etsi kaikki vastaukset
		@RequestMapping(value="/rest/v/", method = RequestMethod.GET)
		public @ResponseBody ResponseEntity<List<VastausKysymykseen>> haeKaikkiVastauksetJSON() {
			List<VastausKysymykseen> vastaukset = dao.haeKaikkiVastaukset();
			
			return new ResponseEntity <List<VastausKysymykseen>>(vastaukset, HttpStatus.OK);
			
		}

		
		
		//etsi yksitt‰inen vastaus
		
		@RequestMapping(value = "/rest/v/{id}", method=RequestMethod.GET)
		public ResponseEntity<Vastaus> haeKaikkiVastaukset(@PathVariable("id") int id){
			Vastaus vastaus = dao.etsiVastaus(id);
			
			return new ResponseEntity<Vastaus>(vastaus, HttpStatus.OK);
		}
	

}
