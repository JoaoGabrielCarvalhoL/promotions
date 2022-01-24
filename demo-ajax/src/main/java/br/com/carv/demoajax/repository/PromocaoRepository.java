package br.com.carv.demoajax.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.carv.demoajax.domain.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long>{
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("update Promocao p set p.likes = p.likes + 1 where p.id = :id")
	void updateSomarLikes(@Param("id") Long id);
	
	@Query("select p.likes from Promocao p where p.id = :id")
	int findLikesById(@Param("id") Long id);
	
	@Query("select distinct p.site from Promocao p where p.site like %:site%")
	List<String> findSitesByTermo(@Param("site") String site);
	
	@Query("select p from Promocao p where p.site like :site")
	Page<Promocao> findBySite(@Param("site") String site, Pageable pageable);
}