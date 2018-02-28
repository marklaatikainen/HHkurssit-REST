package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fi.markl.lukkarit.model.Settings;

public interface SettingsRepository extends CrudRepository<Settings, Long> {
	@Query(value = "SELECT periodi1, periodi2, intensiiviviikko1, intensiiviviikko2, intensiiviviikko3, intensiiviviikko4, nimi, updated FROM asetukset", nativeQuery = true)
	List<Settings> findAll();
}
