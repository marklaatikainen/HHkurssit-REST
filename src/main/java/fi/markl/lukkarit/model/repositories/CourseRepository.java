package fi.markl.lukkarit.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import fi.markl.lukkarit.model.Course;
// TODO: vaihda kysely järkevämmäksi
public interface CourseRepository extends CrudRepository<Course, Long> {

	@Query(value = "SELECT DISTINCT L.opintotunnus, L.suoritustapa, L.exchange, L.ilta, L.kurssinimi, L.ala_fin, L.ala_en, L.opetuskieli, L.opintopisteet, L.toimipiste, L.ohjelma, L.alkaa, L.paattyy, L.link, L.tyyli, GROUP_CONCAT(distinct A.ajoitus ORDER BY ajoitus SEPARATOR ', ') AS ajoitukset from lukkari L left join aikataulut A on A.opinto_id = L.opintotunnus GROUP BY L.opintotunnus ORDER BY L.opintotunnus ", nativeQuery = true)
	List<Course> findAll();

	@Query(value = "SELECT DISTINCT L.opintotunnus, L.suoritustapa, L.exchange, L.ilta, L.kurssinimi, L.ala_fin, L.ala_en, L.opetuskieli, L.opintopisteet, L.toimipiste, L.ohjelma, L.alkaa, L.paattyy, L.link, L.tyyli, A.ajoitus from lukkari L inner join aikataulut A on A.opinto_id = L.opintotunnus where A.ajoitus = ?", nativeQuery = true)
	List<Course> findAllByAjoitus(int ajoitus);

	List<Course> findAllByToimipisteIgnoreCase(String toimipiste);

	List<Course> findAllByOhjelmaIgnoreCase(String ohjelma);

	List<Course> findAllByOpetuskieliIgnoreCase(String opetuskieli);

	List<Course> findAllByKurssinimiIgnoreCase(String kurssinimi);

	List<Course> findAllBySuoritustapaIgnoreCase(String suoritustapa);

	List<Course> findAllByTyyliIgnoreCase(String tyyli);

}