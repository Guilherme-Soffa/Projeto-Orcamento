package br.com.mirante.orcamento.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.mirante.orcamento.domain.ItemOrcamento;

public class RecuperarInconsistenciaServicoTest {
	
	@Test
	public void deveGerarInconsistenciaItemQuantidadeZero() {
		
		RecuperarInconsistenciasServico servico = new RecuperarInconsistenciasServico();
		
		List<String> inconsistencias = new ArrayList<>();
		ItemOrcamento i = new ItemOrcamento(null, null, null, 0, null, 0, 0);
		
		servico.verificarInconsistenciaQuantidadeZero(inconsistencias, i, 5);
		
		Assertions.assertEquals(inconsistencias.get(0), "O item número 5 possui quantidade igual a zero.");

		
	}
	
	@Test
	public void naoDeveGerarInconsistenciaItemQuantidadeZero() {
		
		RecuperarInconsistenciasServico servico = new RecuperarInconsistenciasServico();
		
		List<String> inconsistencias = new ArrayList<>();
		ItemOrcamento i = new ItemOrcamento(null, null, null, 0, null, 0, 0);
		
		servico.verificarInconsistenciaQuantidadeZero(inconsistencias, i, 5);
		
		Assertions.assertEquals(inconsistencias.size(), 0);

		
	}
	
}
