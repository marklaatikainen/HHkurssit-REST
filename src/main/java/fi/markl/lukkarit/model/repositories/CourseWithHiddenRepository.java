package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fi.markl.lukkarit.model.CourseWithHidden;

public interface CourseWithHiddenRepository extends CrudRepository<CourseWithHidden, Long> {
	@Query(value = "SELECT r.kurssi_id AS opintotunnus, L.suoritustapa, L.exchange, L.ilta, L.kurssinimi, L.ala_fin, L.ala_en, L.opetuskieli, L.opintopisteet, L.toimipiste, L.ohjelma, L.alkaa, L.paattyy, L.link, L.tyyli, GROUP_CONCAT(distinct A.ajoitus ORDER BY ajoitus SEPARATOR ', ') AS ajoitukset, o.poistettu FROM ryhma_kurssi r RIGHT JOIN lukkari L ON L.opintotunnus = r.kurssi_id INNER JOIN ryhma_oma o ON r.kurssi_id = o.kurssiId LEFT JOIN aikataulut A on A.opinto_id = L.opintotunnus WHERE o.hID = ? GROUP BY r.kurssi_id ORDER BY r.kurssi_id ", nativeQuery = true)
	List<CourseWithHidden> findOwnCoursesByUserId(int userId);

	// DELETE from ryhma_oma
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM ryhma_oma WHERE hID = :userId AND kurssiId = :courseId", nativeQuery = true)
	void deleteCourse(@Param("userId") int userId, @Param("courseId") String courseId);

	// POST new course to ryhma_oma
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ryhma_oma (hID,kurssiId,poistettu) VALUES (:userId,:courseId,false)", nativeQuery = true)
	void addCourse(@Param("userId") int userId, @Param("courseId") String courseId);

	// POST set poistettu = true
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ryhma_oma (hID,kurssiId,poistettu) VALUES (:userId,:courseId,true)", nativeQuery = true)
	void updateCourse(@Param("userId") int userId, @Param("courseId") String courseId);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM ryhma_oma WHERE hID = :userId", nativeQuery = true)
	void restoreCourses(@Param("userId") int userId);

	// TODO: korjaa!!!
	@Query(value = "SELECT r.kurssi_id AS opintotunnus, L.suoritustapa, L.exchange, L.ilta, L.kurssinimi, L.ala_fin, L.ala_en, L.opetuskieli, L.opintopisteet, L.toimipiste, L.ohjelma, L.alkaa, L.paattyy, L.link, L.tyyli, GROUP_CONCAT(distinct A.ajoitus ORDER BY ajoitus SEPARATOR ', ') AS ajoitukset, L.ilta AS poistettu FROM ryhma_kurssi r RIGHT JOIN lukkari L ON L.opintotunnus = r.kurssi_id left join aikataulut A on A.opinto_id = L.opintotunnus WHERE r.ryhma_ID = ? GROUP BY r.kurssi_id ORDER BY r.kurssi_id", nativeQuery = true)
	List<CourseWithHidden> findGroupsCoursesByGroupId(String groupId);

}
