package br.com.mirante.orcamento.teste;

import java.util.List;

public class Projeto {
	private String name;
	private List<Pacote> packages;
	public Projeto(String name, List<Pacote> packages) {
		super();
		this.name = name;
		this.packages = packages;
	}
	public String getName() {
		return name;
	}
public List<Pacote> getPackages() {
		return packages;
	}
}
