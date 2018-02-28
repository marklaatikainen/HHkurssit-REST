package fi.markl.lukkarit.control;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fi.markl.lukkarit.model.Settings;
import fi.markl.lukkarit.model.repositories.SettingsRepository;

@CrossOrigin
@RestController
public class SettingsController {

	@Autowired
	SettingsRepository repository;
	
	@OneToMany
	@JsonIgnore
	@RequestMapping("/settings")
	public @ResponseBody List<Settings> settings() {
		return (List<Settings>) repository.findAll();
	}

}
