package fi.markl.lukkarit.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.markl.lukkarit.Methods;
import fi.markl.lukkarit.model.Options;

@CrossOrigin
@RestController
public class ProgramController {
	
	@RequestMapping(value = "/program", method = RequestMethod.GET)
	public @ResponseBody List<Options> options() {
		List<Options> optionList = new ArrayList<Options>();

		optionList.add(new Options(Methods.GET, "/listofvariants", "show list of all programs"));

		return optionList;
	}

	
}
