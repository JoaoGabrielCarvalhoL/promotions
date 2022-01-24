package br.com.carv.demoajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.demoajax.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
