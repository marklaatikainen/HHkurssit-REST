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
@RequestMapping("/")
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Options> options() {
		List<Options> optionList = new ArrayList<Options>();

		optionList.add(new Options(Methods.GET, "/course", "courses"));
		optionList.add(new Options(Methods.GET, "/group", "groups"));
		optionList.add(new Options(Methods.GET, "/program", "programs"));
		optionList.add(new Options(Methods.GET, "/settings", "show db settings/info"));
		optionList.add(new Options(Methods.GET, "/time", "timetables"));
		optionList.add(new Options(Methods.GET, "/user", "users"));

		return optionList;
	}

}