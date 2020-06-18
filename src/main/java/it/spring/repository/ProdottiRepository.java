package it.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.spring.model.Prodotti;

public interface ProdottiRepository extends CrudRepository<Prodotti, Long> {
	
	@Query(value = "SELECT p FROM Prodotti p WHERE p.name LIKE '%' || :keyword || '%'"
			+ " OR p.quantity LIKE '%' || :keyword || '%'"
			+ " OR p.category LIKE '%' || :keyword || '%'")
	public List<Prodotti> search(@Param("keyword") String keyword);
}