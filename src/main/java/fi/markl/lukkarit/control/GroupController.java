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
import fi.markl.lukkarit.model.Group;
import fi.markl.lukkarit.model.Opettaja;
import fi.markl.lukkarit.model.Options;
import fi.markl.lukkarit.model.repositories.GroupRepository;
import fi.markl.lukkarit.model.repositories.TeacherRepository;

@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {
	@Autowired
	GroupRepository repository;

	@Autowired
	private TeacherRepository teacherRepo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Options> options() {
		List<Options> optionList = new ArrayList<Options>();

		optionList.add(new Options(Methods.GET, "/{id}", "get all group's courses"));

		return optionList;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Group> findByGroup(@PathVariable String id) {
		List<Group> groupList = new ArrayList<Group>();

		List<Group> groups = repository.findByIdIgnoreCase(id);
		List<Opettaja> teachers = teacherRepo.findAll();

		for (Group group : groups) {
			List<Opettaja> teacherList = new ArrayList<Opettaja>();

			for (Opettaja teacher : teachers) {
				if (group.getKurssi_id().equals(teacher.getOpintotunnus())) {
					teacher.setOpintotunnus(null);
					teacherList.add(teacher);
				}
			}
			group.setLink("http://www.haaga-helia.fi/fi/opinto-opas/opintojaksokuvaukset/" + group.getLink());
			group.setOpettaja(teacherList);
			groupList.add(group);
		}

		return groupList;
	}

}
