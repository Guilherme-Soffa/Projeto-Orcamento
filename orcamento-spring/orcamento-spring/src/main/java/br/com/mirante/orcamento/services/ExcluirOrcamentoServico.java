package br.com.mirante.orcamento.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;

import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class ExcluirOrcamentoServico {

	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemOrcamentoRepositoryJpa itensrepositorio;
	
	@Transactional
	public void excluir(Integer id) {
		itensrepositorio.deleteByidOrcamento(id);
		repositorio.excluir(id);
	}
}
