package fi.markl.lukkarit.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.markl.lukkarit.Methods;
import fi.markl.lukkarit.model.Course;
import fi.markl.lukkarit.model.Opettaja;
import fi.markl.lukkarit.model.Options;
import fi.markl.lukkarit.model.Variants;
import fi.markl.lukkarit.model.repositories.CourseRepository;
import fi.markl.lukkarit.model.repositories.TeacherRepository;
import fi.markl.lukkarit.model.repositories.VariantsRepository;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseRepository repository;

	@Autowired
	private VariantsRepository vrepo;

	@Autowired
	private TeacherRepository teacherRepo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Options> options() {
		List<Options> optionList = new ArrayList<Options>();

		optionList.add(new Options(Methods.GET, "/all", "get all courses"));
		optionList.add(new Options(Methods.GET, "/{id}", "find course by it's id"));
		optionList.add(new Options(Methods.GET, "/campus", "show courses in that campus"));
		optionList.add(new Options(Methods.GET, "/language", "show courses in that language"));
		optionList.add(new Options(Methods.GET, "/method", "show course methods"));
		optionList.add(new Options(Methods.GET, "/program", "show courses in that program"));
		optionList.add(new Options(Methods.GET, "/coursename", "find course by it's name"));
		optionList.add(new Options(Methods.GET, "/timing", "show courses by timing"));
		optionList.add(new Options(Methods.GET, "/optionlists", "shows all variants"));

		return optionList;
	}

	@RequestMapping("/all")
	public @ResponseBody List<Course> getAllCourses() {
		List<Course> allCoursesList = new ArrayList<Course>();

		List<Course> courses = repository.findAll();
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/campus/{tp}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findByToimipiste(@PathVariable String tp) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllByToimipisteIgnoreCase(tp);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/language/{ok}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findByOpetuskieli(@PathVariable String ok) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllByOpetuskieliIgnoreCase(ok);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/method/{st}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findBySuoritustapa(@PathVariable String st) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllBySuoritustapaIgnoreCase(st);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/program/{oh}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findByOhjelma(@PathVariable String oh) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllByOhjelmaIgnoreCase(oh);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/coursename/{kn}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findByKurssiNimi(@PathVariable String kn) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllByKurssinimiIgnoreCase(kn);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/tyyli/{ty}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findByTyyli(@PathVariable String ty) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllByTyyliIgnoreCase(ty);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/ajoitus/{aj}", method = RequestMethod.GET)
	public @ResponseBody List<Course> findByAjoitus(@PathVariable int aj) {
		List<Course> allCoursesList = new ArrayList<Course>();
		List<Course> courses = repository.findAllByAjoitus(aj);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			allCoursesList.add(course);
		}

		return allCoursesList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Course getCourse(@PathVariable String id) {
		Map<String, Course> map = new HashMap<String, Course>();

		List<Course> courses = repository.findAll();
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Course course : courses) {
			String f = course.getOpintotunnus();
			map.put(f, course);
		}

		List<Opettaja> selTeacher = new ArrayList<Opettaja>();

		for (Opettaja teacher : teachers) {
			if (id.equals(teacher.getOpintotunnus())) {
				teacher.setOpintotunnus(null);
				selTeacher.add(teacher);
			}
		}

		// hae valittu kurssi mapista opintotunnuksella
		Course selected = map.get(id);
		selected.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + selected.getLinkki());
		selected.setOpettaja(selTeacher);

		return selected;
	}

	@RequestMapping(value = "/optionlists", method = RequestMethod.GET)
	public @ResponseBody Variants getLists() {
		List<String> koulutusohjelmat = vrepo.findAllOhjelma();
		List<String> opetuskielet = vrepo.findAllOpetuskieli();
		List<String> suoritustavat = vrepo.findAllSuoritustapa();
		List<String> toimipisteet = vrepo.findAllToimipiste();

		Variants result = new Variants();
		result.setKoulutusohjelmat(koulutusohjelmat);
		result.setOpetuskielet(opetuskielet);
		result.setSuoritustavat(suoritustavat);
		result.setToimipisteet(toimipisteet);

		return result;
	}
}
