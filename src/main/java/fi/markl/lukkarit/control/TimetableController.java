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
import fi.markl.lukkarit.model.Time;
import fi.markl.lukkarit.model.TimeInfo;
import fi.markl.lukkarit.model.Times;
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
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public @ResponseBody Time timetables(@PathVariable String id) {
		Time result = new Time();
		TimeInfo timeinfo = null;
		ArrayList<TimeInfo> timeInfoList = new ArrayList<TimeInfo>();
		List<Times> queryResult = repository.findAllById(id);
		ArrayList<String> templist = null;

		result.setOpintotunnus(queryResult.get(0).getId());
		result.setKurssinimi(queryResult.get(0).getName());

		int last = 0;
		for (Times time : queryResult) {
			if (last != time.getPeriodi()) {
				// periodi timeinfoon
				timeinfo = new TimeInfo();
				templist = new ArrayList<String>();
				timeinfo.setPeriodi(time.getPeriodi());
				// ajat listaan ja työnnetään lista timeinfoon

				timeinfo.setAika(setList(time, templist));
				// timeinfo työnnetään timeen
				timeInfoList.add(timeinfo);
				// toisto
				last = time.getPeriodi();
			} else {
				timeinfo.setAika(setList(time, templist));
			}
			result.setAikataulut(timeInfoList);
		}

		return result;
	}

	// get group courses
	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Time> groupTimetables(@PathVariable String id) {
		TimeInfo timeinfo = null;
		List<Time> resultList = new ArrayList<Time>();
		ArrayList<TimeInfo> timeInfoList = new ArrayList<TimeInfo>();
		List<Times> queryResult = repository.findByGroup(id);
		ArrayList<String> templist = null;
		Time result = null;

		Times lastcourse = queryResult.get(0);
		int lastperiod = 0;
		boolean first = true;
		for (Times time : queryResult) {

			if (first) {
				// ensimmäinen kierros
				result = new Time();
				timeinfo = new TimeInfo();
				templist = new ArrayList<String>();
				// Uusi kurssi-id
				result.setOpintotunnus(time.getId());
				result.setKurssinimi(time.getName());
				timeinfo.setPeriodi(time.getPeriodi());
				timeinfo.setAika(setList(time, templist));
				timeInfoList.add(timeinfo);
				first = false;
				lastperiod = time.getPeriodi();
			} else if (lastcourse.getId().equals(result.getOpintotunnus())) {
				// sama kurssi, kuin edellisellä kierroksella
				if (time.getId() != lastcourse.getId()) {
					lastperiod = 0;
				}
				if (lastperiod != time.getPeriodi()) {
					// uusi periodi
					timeinfo = new TimeInfo();
					templist = new ArrayList<String>();
					timeinfo.setPeriodi(time.getPeriodi());

					timeinfo.setAika(setList(time, templist));

					if (timeinfo.getPeriodi() == time.getPeriodi() && result.getOpintotunnus().equals(time.getId())) {
						timeInfoList.add(timeinfo);
					}
				} else {
					// sama periodi, uusi aika
					if (time.getId().equals(lastcourse.getId())) {
						timeinfo.setAika(setList(time, templist));

						if (!timeInfoList.contains(timeinfo)) {
							timeInfoList.add(timeinfo);
						}
					}
				}
				lastperiod = time.getPeriodi();
			} else {
				// uusi kurssi
				result = new Time();
				timeinfo = new TimeInfo();
				templist = new ArrayList<String>();
				timeInfoList = new ArrayList<TimeInfo>();

				// Uusi kurssi-id
				result.setOpintotunnus(time.getId());
				result.setKurssinimi(time.getName());
				timeinfo.setPeriodi(time.getPeriodi());
				timeinfo.setAika(setList(time, templist));
				timeInfoList.add(timeinfo);
				lastperiod = 0;
			}

			if (result.getOpintotunnus().equals(time.getId()) && result.getAikataulut() == null) {
				result.setAikataulut(timeInfoList);
				resultList.add(result);
			}

			lastcourse = time;
		}

		return resultList;
	}

	// get user courses
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody Time userTimetables(@PathVariable int id) {
		return null;

	}

	// asetetaan aikataulut listaan
	private ArrayList<String> setList(Times time, ArrayList<String> templist) {
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
