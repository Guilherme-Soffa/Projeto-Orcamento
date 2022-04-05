package br.com.mirante.orcamento.repository;

import br.com.mirante.orcamento.domain.Produto;


import java.util.List;
import java.util.Map;


public interface ReferenciaPrecoRepository {

    Map<String, Produto> recuperarProdutos(Integer mes, Integer ano, List<String> codigos);

}