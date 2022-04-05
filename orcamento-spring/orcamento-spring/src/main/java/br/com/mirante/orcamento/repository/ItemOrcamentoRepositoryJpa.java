package br.com.mirante.orcamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.mirante.orcamento.domain.ItemOrcamento;

public interface ItemOrcamentoRepositoryJpa extends JpaRepository<ItemOrcamento, Integer>{
	
	void deleteByid(Integer id);
	
	@Modifying
	@Query("delete from ItemOrcamento i where i.orcamento.id = :idOrcamento")
	void deleteByidOrcamento(Integer idOrcamento);
	
	@Query("from ItemOrcamento i where i.orcamento.id = :idOrcamento")
	List<ItemOrcamento> listarPorIdOrcamento(Integer idOrcamento);
	
	
}
