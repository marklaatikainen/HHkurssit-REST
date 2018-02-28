package fi.markl.lukkarit.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.markl.lukkarit.model.Variant;
import fi.markl.lukkarit.model.Variants;
import fi.markl.lukkarit.model.repositories.VariantsRepository;

@CrossOrigin
@RestController
public class ListController {
	
	@Autowired
	private VariantsRepository variantsrepository;

	@RequestMapping(value = "/course/program", method = RequestMethod.GET)
	public @ResponseBody Variants getPrograms() {
		Variants variant = new Variants();
		List<Variant> queryresult = variantsrepository.findAllOhjelma();
		List<String> templist = new ArrayList<String>();
		
		for (Variant prog : queryresult) {
			templist.add(prog.getvariant());
		}
		variant.setVaihtoehdot(templist);
		return variant;
	}
	
	@RequestMapping(value = "/course/language", method = RequestMethod.GET)
	public @ResponseBody Variants getLanguages() {
		Variants variant = new Variants();
		List<Variant> queryresult = variantsrepository.findAllOpetuskieli();
		List<String> templist = new ArrayList<String>();
		
		for (Variant prog : queryresult) {
			templist.add(prog.getvariant());
		}
		variant.setVaihtoehdot(templist);
		return variant;
	}

	@RequestMapping(value = "/course/method", method = RequestMethod.GET)
	public @ResponseBody Variants getMethods() {
		Variants variant = new Variants();
		List<Variant> queryresult = variantsrepository.findAllSuoritustapa();
		List<String> templist = new ArrayList<String>();
		
		for (Variant prog : queryresult) {
			templist.add(prog.getvariant());
		}
		variant.setVaihtoehdot(templist);
		return variant;
	}

	@RequestMapping(value = "/course/campus", method = RequestMethod.GET)
	public @ResponseBody Variants getCampuses() {
		Variants variant = new Variants();
		List<Variant> queryresult = variantsrepository.findAllToimipiste();
		List<String> templist = new ArrayList<String>();
		
		for (Variant prog : queryresult) {
			templist.add(prog.getvariant());
		}
		variant.setVaihtoehdot(templist);
		return variant;
	}

}
