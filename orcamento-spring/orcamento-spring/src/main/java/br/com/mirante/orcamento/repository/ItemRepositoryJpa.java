package br.com.mirante.orcamento.repository;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.mirante.orcamento.domain.ItemOrcamento;


public class ItemRepositoryJpa implements ItemRepository {
	
	
	public ItemRepositoryJpa(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private EntityManager entityManager;  
	
	@Override
	public void excluir(Integer idItem) {

		var itemRecuperado = entityManager.find(ItemOrcamento.class, idItem);
		if (itemRecuperado != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(itemRecuperado);
			entityManager.getTransaction().commit();
		}

	}
	@Override
	public void salvar(List<ItemOrcamento> itens) {
		itens.forEach(entityManager::persist);
	}
	@Override
	public void excluirItens(Integer idOrcamento) {
		entityManager.createQuery("delete from ItemOrcamento i where i.orcamento.id = :idOrcamento").setParameter("idOrcamento", idOrcamento).executeUpdate();
		
	}

}