package fi.markl.lukkarit.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.markl.lukkarit.Methods;
import fi.markl.lukkarit.model.Options;
import fi.markl.lukkarit.model.Times;
import fi.markl.lukkarit.model.TimesOutput;
import fi.markl.lukkarit.model.repositories.TimetableRepository;

@CrossOrigin
@RestController
@RequestMapping("/time")
public class TimetableController {
	@Autowired
	TimetableRepository repository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Options> options() {
		List<Options> optionList = new ArrayList<Options>();

		optionList.add(new Options(Methods.GET, "/course/{id}", "course's timetable"));
		optionList.add(new Options(Methods.GET, "/group/{id}", "group's timetable"));
		optionList.add(new Options(Methods.GET, "/user/{id}", "user's timetable"));

		return optionList;
	}

	// get by course
	@RequestMapping(value = "/course/{id}/{period}", method = RequestMethod.GET)
	public @ResponseBody List<TimesOutput> timetables(@PathVariable String id, @PathVariable int period) {
		List<Times> queryResult = repository.findAllById(id, period);
		List<TimesOutput> outputList = new ArrayList<TimesOutput>();

		for (Times time : queryResult) {
			TimesOutput out = new TimesOutput();
			out.setId(time.getId());
			out.setName(time.getName());
			out.setTime(setList(time));
			out.setStr(time.getAj_str());
			outputList.add(out);
		}

		return outputList;
	}

	// get group courses
	@RequestMapping(value = "/group/{id}/{period}", method = RequestMethod.GET)
	public @ResponseBody List<TimesOutput> groupTimetables(@PathVariable String id, @PathVariable int period) {
		List<Times> queryResult = repository.findByGroup(id, period);
		List<TimesOutput> outputList = new ArrayList<TimesOutput>();

		for (Times time : queryResult) {
			TimesOutput out = new TimesOutput();
			out.setId(time.getId());
			out.setName(time.getName());
			out.setTime(setList(time));
			out.setStr(time.getAj_str());
			outputList.add(out);
		}

		return outputList;
	}

	// get user courses
	@RequestMapping(value = "/user/{userId}/{groupId}/{period}", method = RequestMethod.GET)
	public @ResponseBody List<TimesOutput> userTimetables(@PathVariable String groupId, @PathVariable int userId,
			@PathVariable int period) {
		List<Times> queryResult = repository.findAllOwnCourses(groupId, userId, period);
		List<TimesOutput> outputList = new ArrayList<TimesOutput>();

		for (Times time : queryResult) {
			TimesOutput out = new TimesOutput();
			out.setId(time.getId());
			out.setName(time.getName());
			out.setTime(setList(time));
			out.setStr(time.getAj_str());
			outputList.add(out);
		}

		return outputList;
	}

	// asetetaan aikataulut listaan
	private ArrayList<String> setList(Times time) {
		ArrayList<String> templist = new ArrayList<String>();

		if (!time.getMaa().isEmpty()) {
			templist.add(time.getMaa());
		}
		if (!time.getTii().isEmpty()) {
			templist.add(time.getTii());
		}
		if (!time.getKes().isEmpty()) {
			templist.add(time.getKes());
		}
		if (!time.getTor().isEmpty()) {
			templist.add(time.getTor());
		}
		if (!time.getPer().isEmpty()) {
			templist.add(time.getPer());
		}
		return templist;
	}

}
