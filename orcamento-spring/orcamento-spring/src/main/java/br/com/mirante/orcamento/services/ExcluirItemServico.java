package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.repository.ItemRepository;


public class ExcluirItemServico {

	private ItemRepository repositorio;

	public void excluirItem(Integer idItem) {

		repositorio.excluir(idItem);
	}
}