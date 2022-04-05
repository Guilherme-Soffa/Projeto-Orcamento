package br.com.mirante.orcamento.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	static EntityManager getEntityManager() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = fabrica.createEntityManager();
		return entityManager;
	}
}