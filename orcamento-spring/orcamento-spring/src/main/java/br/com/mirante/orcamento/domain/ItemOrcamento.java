
package br.com.mirante.orcamento.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ITEM_ORCAMENTO")
public class ItemOrcamento implements Serializable {


	private static final long serialVersionUID = 4521914098412108603L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String origem;

	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "VALOR_UNITARIO")
	private Float valorUnitario;

	@Column(name = "UNIDADE")
	private String unidade;

	private Float quantidade;

	@Column(name = "VALOR_TOTAL_INFORMADO")
	private Float valorTotalInformado;

	@ManyToOne
	@JoinColumn(name = "ID_ORCAMENTO")
	@JsonIgnore
	private Orcamento orcamento;

	public ItemOrcamento(Integer id, String origem, String codigoItem, String descricaoItem, float valorUnitario,
			String unidadeMedida, float quantidade, float valorTotalInformado) {

		this(origem, codigoItem, descricaoItem, valorUnitario, unidadeMedida, quantidade, valorTotalInformado);
		this.id = id;
	}

	protected ItemOrcamento() {

	}

	public ItemOrcamento(String origem, String codigoItem, String descricaoItem, float valorUnitario,
			String unidadeMedida, float quantidade, float valorTotalInformado) {

		this.origem = origem;
		this.codigo = codigoItem;
		this.descricao = descricaoItem;
		this.valorUnitario = valorUnitario;
		this.unidade = unidadeMedida;
		this.quantidade = quantidade;
		this.valorTotalInformado = valorTotalInformado;
	}

	public Integer getId() {
		return id;
	}

	public boolean possuiInconsistencia() {
		var diferenca = getValorTotalCalculado() - getValorTotalInformado();
		return diferenca > 0.009 || diferenca < -0.009;
	}

	public String getOrigem() {
		return origem;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public String getUnidade() {
		return unidade;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public float getValorTotalInformado() {
		return valorTotalInformado;
	}

	public String getCodigoItem() {
		return codigo;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigo = codigoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricao = descricaoItem;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidade = unidadeMedida;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorTotalInformado(Float valorTotalInformado) {
		this.valorTotalInformado = valorTotalInformado;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Float getValorTotalCalculado() {
		return quantidade*valorUnitario;
	}

}