package it.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.model.Prodotti;
import it.spring.repository.ProdottiRepository;

@Service
@Transactional
public class ProdottiService {
	@Autowired ProdottiRepository repo;
	
	public void save(Prodotti prodotti) {
		repo.save(prodotti);
	}
	
	public List<Prodotti> listAll() {
		return (List<Prodotti>) repo.findAll();
	}
	
	public Prodotti get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Prodotti> search(String keyword) {
		return repo.search(keyword);
	}
}