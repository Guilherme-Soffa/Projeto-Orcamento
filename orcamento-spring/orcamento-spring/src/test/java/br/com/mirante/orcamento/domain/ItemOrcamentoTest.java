package br.com.mirante.orcamento.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemOrcamentoTest {
	
	@Test
	public void deveGerarInconsistencia() {
		ItemOrcamento item = new ItemOrcamento(
			1, "IBGE", "abc", "teste", 5.2F, "un", 3.5f, 18.3F
			);	
	Assertions.assertTrue(item.possuiInconsistencia());
	}
	
	@Test
	public void deveGerarInconsistenciaCalculadoSuperior() {
		ItemOrcamento item = new ItemOrcamento(
			1, "IBGE", "abc", "teste", 5.2F, "un", 3.5f, 18.1F
			);	
	Assertions.assertTrue(item.possuiInconsistencia());
	}
	
	
	@Test
	public void naoDeveGerarInconsistencia() {
		ItemOrcamento item = new ItemOrcamento(
				1, "IBGE", "abc", "teste", 3.2F, "un", 7.2f, 23.04F
				);	
		Assertions.assertFalse(item.possuiInconsistencia());
	}

}
