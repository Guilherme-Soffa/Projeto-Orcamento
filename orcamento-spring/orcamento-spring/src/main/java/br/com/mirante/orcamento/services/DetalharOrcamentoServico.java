package br.com.mirante.orcamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class DetalharOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemOrcamentoRepositoryJpa itensRepositorio;

	public Orcamento recuperar(int id) {
		return repositorio.recuperar(id);
	}

	public List<ItemOrcamento> recuperarItens(Integer idOrcamento) {
		return itensRepositorio.listarPorIdOrcamento(idOrcamento);
	}

}