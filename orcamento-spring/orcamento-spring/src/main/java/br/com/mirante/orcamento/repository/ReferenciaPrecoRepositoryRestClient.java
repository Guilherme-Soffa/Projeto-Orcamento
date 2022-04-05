package br.com.mirante.orcamento.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.mirante.orcamento.domain.Produto;
import br.com.mirante.orcamento.teste.Pacote;
import br.com.mirante.orcamento.teste.Projeto;

@Repository
public class ReferenciaPrecoRepositoryRestClient implements ReferenciaPrecoRepository{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Map<String, Produto> recuperarProdutos(Integer mes, Integer ano, List<String> codigos) {
		Projeto[] projetos = restTemplate.getForObject("https://boiling-sea-30664.herokuapp.com/api/projects/", Projeto[].class);
		
		
		for(Projeto projeto : projetos) {
			System.out.println("Projeto: " + projeto.getName());
			for(Pacote p : projeto.getPackages()) {
				System.out.println(p.getName() + ":" + p.getVersion());
			}
		}
		
		Map<String, Produto> produtos = new HashMap<>();
        produtos.put("1234", new Produto("IBGE", "1234", "Arroz", "T", 2.0F));
        return produtos;
	}

}