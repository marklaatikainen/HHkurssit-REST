package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fi.markl.lukkarit.model.Variant;

public interface VariantsRepository extends CrudRepository<Variant, Long>{
	@Query(value = "SELECT DISTINCT ohjelma as variant FROM lukkari WHERE ohjelma !='' ORDER BY ohjelma ASC", nativeQuery = true)
	List<String> findAllOhjelma();
	
	@Query(value = "SELECT DISTINCT opetuskieli as variant FROM lukkari WHERE opetuskieli !='' ORDER BY opetuskieli ASC", nativeQuery = true)
	List<String> findAllOpetuskieli();

	@Query(value = "SELECT DISTINCT toimipiste as variant FROM lukkari WHERE toimipiste !='' ORDER BY toimipiste ASC", nativeQuery = true)
	List<String> findAllToimipiste();

	@Query(value = "SELECT DISTINCT suoritustapa as variant FROM lukkari WHERE suoritustapa !='' ORDER BY suoritustapa ASC", nativeQuery = true)
	List<String> findAllSuoritustapa();
}
