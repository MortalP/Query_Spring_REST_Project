package fi.bfk.kysely.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {

	@RequestMapping(value = "/uusi", method = RequestMethod.GET)
	public String getView(Model model) {
		return "kyse/createForm";
	}

}
