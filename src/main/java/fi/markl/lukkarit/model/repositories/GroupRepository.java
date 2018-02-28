package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fi.markl.lukkarit.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
	@Query(value = "SELECT r.kurssi_id, r.ryhma_ID, lukkari.suoritustapa, lukkari.exchange, lukkari.ilta, lukkari.kurssinimi, lukkari.ala_fin, lukkari.ala_en, lukkari.opetuskieli, lukkari.opintopisteet, lukkari.toimipiste, lukkari.ohjelma, lukkari.alkaa, lukkari.paattyy, lukkari.link, lukkari.tyyli FROM ryhma_kurssi r RIGHT JOIN lukkari ON lukkari.opintotunnus = r.kurssi_id WHERE r.ryhma_ID = ?1", nativeQuery = true)
	public List<Group> findByIdIgnoreCase(String id);
}