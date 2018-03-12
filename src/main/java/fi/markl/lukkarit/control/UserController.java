package fi.markl.lukkarit.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.markl.lukkarit.Methods;
import fi.markl.lukkarit.model.CourseWithHidden;
import fi.markl.lukkarit.model.Opettaja;
import fi.markl.lukkarit.model.Options;
import fi.markl.lukkarit.model.User;
import fi.markl.lukkarit.model.repositories.CourseWithHiddenRepository;
import fi.markl.lukkarit.model.repositories.TeacherRepository;
import fi.markl.lukkarit.model.repositories.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userrepository;

	@Autowired
	private CourseWithHiddenRepository whiddenrepository;

	@Autowired
	private TeacherRepository teacherRepo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Options> options() {
		List<Options> optionList = new ArrayList<Options>();

		optionList.add(new Options(Methods.GET, "/{username}", "show user info"));
		optionList.add(new Options(Methods.POST, "/register",
				"register new user: { String: 'username', String: firstName, String: lastName, String: userGroup, String: passwordHash }"));
		optionList.add(new Options(Methods.PUT, "/",
				"update user info: { String: 'username', String: firstName, String: lastName, String: userGroup, String: passwordHash }"));
		optionList.add(new Options(Methods.DELETE, "/{id}", "delete user"));
		optionList.add(new Options(Methods.GET, "/own/{userId}/{groupid}", "show own courses"));
		optionList.add(new Options(Methods.POST, "/own/{userId}/{groupId}/{courseId}", "add own course"));
		optionList.add(new Options(Methods.DELETE, "/own/{userId}/{groupId}/{courseId}", "delete own course"));
		optionList.add(new Options(Methods.DELETE, "/own/restore/{userid}", "restore original list"));
		return optionList;
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public User getOwnProfile(@PathVariable(value = "username") String un) {
		return userrepository.findByUsername(un);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setRole("USER");
		user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
		return userrepository.save(user);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
		return userrepository.update(user.getUsername(), user.getFirstName(), user.getLastName(), user.getUserGroup(),
				user.getPasswordHash(), user.getId());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		userrepository.delete(id);
		return "success";
	}

	// TODO: Korjaa järkevämmäksi
	// haetaan omat kurssit
	@RequestMapping(value = "/{userId}/{groupId}", method = RequestMethod.GET)
	public @ResponseBody List<CourseWithHidden> getOwnCoursesList(@PathVariable int userId,
			@PathVariable String groupId) {
		List<CourseWithHidden> ownList = new ArrayList<CourseWithHidden>();

		List<CourseWithHidden> ownCourses = whiddenrepository.findOwnCoursesByUserId(userId);
		List<CourseWithHidden> groupCourses = whiddenrepository.findGroupsCoursesByGroupId(groupId);
		List<Opettaja> teachers = teacherRepo.findAll();
		List<CourseWithHidden> finalCourses = new ArrayList<CourseWithHidden>();
		Map<String, CourseWithHidden> map = new HashMap<String, CourseWithHidden>();

		for (CourseWithHidden k : groupCourses) {
			// lisätään mappiin
			map.put(k.getOpintotunnus(), k);
		}

		// lisätään kaikki omat lisätyt mappiin
		for (CourseWithHidden o : ownCourses) {
			if (!o.getPoistettu()) {
				map.put(o.getOpintotunnus(), o);
			} else {
				map.remove(o.getOpintotunnus());
			}
		}

		// käydään läpi map ja lisätään kaikki listalle
		for (Map.Entry<String, CourseWithHidden> entry : map.entrySet()) {
			finalCourses.add(entry.getValue());
		}

		// Lisätään opettajat kursseille
		for (CourseWithHidden course : finalCourses) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (course.getOpintotunnus().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			course.setLinkki("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + course.getLinkki());
			course.setOpettaja(teacherList);
			ownList.add(course);
		}
		return ownList;
	}

	// poistetaan oma kurssi
	@RequestMapping(value = "/own/{userId}/{groupId}/{courseId}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> removeCourse(@PathVariable int userId, @PathVariable String groupId,
			@PathVariable String courseId) {
		List<CourseWithHidden> groupCourses = whiddenrepository.findGroupsCoursesByGroupId(groupId);

		// löytyykö kurssi ryhmältä?
		for (CourseWithHidden course : groupCourses) {
			if (course.getOpintotunnus().equals(courseId)) {
				// merkitään omalle listalle poistetuksi
				whiddenrepository.updateCourse(userId, courseId);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
		}
		// kurssi poistetaan omalta listalta
		whiddenrepository.deleteCourse(userId, courseId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	// lisätään oma kurssi
	@RequestMapping(value = "/own/{userId}/{groupId}/{courseId}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> addCourse(@PathVariable int userId, @PathVariable String groupId,
			@PathVariable String courseId) {
		List<CourseWithHidden> ownCourses = whiddenrepository.findOwnCoursesByUserId(userId);
		List<CourseWithHidden> groupCourses = whiddenrepository.findGroupsCoursesByGroupId(groupId);

		for (CourseWithHidden group : groupCourses) {
			// kurssi löytyy ryhmältä joten poistetaan omasta listasta piilotus
			if (group.getOpintotunnus().equals(courseId)) {
				whiddenrepository.deleteCourse(userId, courseId);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
		}

		for (CourseWithHidden own : ownCourses) {
			if (own.getOpintotunnus().equals(courseId)) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
		}
		// lisätään kurssi omiin
		whiddenrepository.addCourse(userId, courseId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	// nollataan omat kurssit
	@RequestMapping(value = "/own/restore/{userId}", method = RequestMethod.DELETE)
	public @ResponseBody String restoreDefaults(@PathVariable int userId) {
		whiddenrepository.restoreCourses(userId);
		return "Kurssit palautettu";
	}
}