package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fi.markl.lukkarit.model.Opettaja;

public interface TeacherRepository extends CrudRepository<Opettaja, Long> {
	@Query(value = "SELECT DISTINCT lukkari.opintotunnus, opettajat.op_etunimi, opettajat.op_sukunimi FROM ope_kurssi INNER JOIN lukkari ON ope_kurssi.kurssi_id = lukkari.opintotunnus INNER JOIN opettajat ON ope_kurssi.opettaja_id = opettajat.op_id ORDER BY lukkari.opintotunnus", nativeQuery = true)
	List<Opettaja> findAll();
}
