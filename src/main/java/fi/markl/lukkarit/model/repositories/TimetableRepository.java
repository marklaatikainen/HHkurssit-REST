package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.markl.lukkarit.model.Times;

public interface TimetableRepository extends CrudRepository<Times, Long> {

	@Query(value = "SELECT DISTINCT lukkari.kurssinimi, lukkari.opintotunnus, a.ajoitus, a.maa, a.tii, a.kes, a.tor, a.per, a.aj_string FROM aikataulut a INNER JOIN lukkari ON lukkari.opintotunnus = a.opinto_id WHERE a.opinto_id = ? AND a.ajoitus = ?", nativeQuery = true)
	List<Times> findAllById(String id, int period);

	@Query(value = "SELECT lukkari.kurssinimi, r.kurssi_id AS opintotunnus, aikataulut.maa, aikataulut.tii, aikataulut.kes, aikataulut.tor, aikataulut.per, aikataulut.aj_string, aikataulut.ajoitus FROM ryhma_kurssi r INNER JOIN lukkari ON lukkari.opintotunnus = r.kurssi_id INNER JOIN aikataulut ON aikataulut.opinto_id = r.kurssi_id WHERE r.ryhma_ID = ? AND aikataulut.ajoitus = ?", nativeQuery = true)
	List<Times> findByGroup(String id, int period);

	@Query(value = "SELECT lukkari.kurssinimi, r.kurssi_id AS opintotunnus, aikataulut.maa, aikataulut.tii, aikataulut.kes, aikataulut.tor, aikataulut.per, aikataulut.aj_string, aikataulut.ajoitus FROM ryhma_kurssi r INNER JOIN lukkari ON lukkari.opintotunnus = r.kurssi_id INNER JOIN aikataulut ON aikataulut.opinto_id = r.kurssi_id WHERE r.ryhma_ID = ? AND r.kurssi_id NOT IN (SELECT kurssiID FROM ryhma_oma WHERE hID = ? AND poistettu = 1) AND aikataulut.ajoitus = ?", nativeQuery = true)
	List<Times> findGroupsTimetablesWithoutRemoved(String groupId, int userId, int period);
	
	@Query(value = "SELECT r.kurssiId, lukkari.kurssinimi, aikataulut.maa, aikataulut.tii, aikataulut.kes, aikataulut.tor, aikataulut.per, aikataulut.aj_string FROM ryhma_oma r INNER JOIN lukkari ON lukkari.opintotunnus = r.kurssiId INNER JOIN aikataulut ON aikataulut.opinto_id = r.kurssiId WHERE aikataulut.ajoitus = :period AND r.poistettu = 0 AND r.hID = :userId", nativeQuery = true)
	List<Times> findOwnTimetables(@Param("period") int period, @Param("userId") int userId);
}