import React from 'react';
import axios from 'axios';
import { AiFillDelete } from "react-icons/ai";
import { FaSearchDollar } from 'react-icons/fa';

function Orcamentos(props) {
    const [orcamentos, setOrcamentos] = React.useState([])
    const [clicouNoBotao, setClicouNoBotao] = React.useState(false)
    const [descricao, setDescricao] = React.useState('')
    const [mes, setMes] = React.useState('')
    const [ano, setAno] = React.useState('')
    const [valorTotalInformado, setValorTotalInformado] = React.useState('')
    const [itensOrcamentoCSV, setItensOrcamentoCSV] = React.useState('')

    React.useEffect(() => carregarDados(), [])

    async function carregarDados() {
        let response = await axios.get('/orcamentos')
        let dados = response.data
        setOrcamentos(dados)

    }

    async function handleDeleteClick(idOrcamento) {
        const url = `/orcamentos/${idOrcamento}`
        await axios.delete(url)
        carregarDados()
    }

    function obterItens(){
        const linhas = itensOrcamentoCSV.split('\n')
        
        return linhas.map(linha => {
            const atributos = linha.split(';')
            return {
            origem: atributos[0],
            codigo: atributos[1],
            descricao: atributos[2],
            quantidade: atributos[3],
            unidade: atributos[4],
            valorUnitario: atributos[5],
            valorTotalInformado: atributos[6]
            }
        })
    }

    async function handleSaveClick() {
        const url = '/orcamentos'
        const dados = {
            orcamento: {
                descricao,
                mes,
                ano,
                valorTotalInformado
            },
            itens: obterItens()
        }
        await axios.post(url, dados)
        carregarDados('')
        setDescricao('')
        setMes('')
        setAno('')
        setValorTotalInformado('')
        setClicouNoBotao(false)
    }
    return(
        <>
        <table className="table table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Descri????o</th>
            <th scope="col">Per??odo</th>
            <th scope="col">Valor Total Informado</th>
            <th scope="col">Valor Total Calculado</th>
            <th scope="col">Diferen??a de pre??o</th>
            <th scope="col">A????es</th>
          </tr>
        </thead>
        <tbody>
          {
            orcamentos.map((orcamento) => (
              <tr key={orcamento.id}>
                <th scope="row">{orcamento.id}</th>
                <td>{orcamento.descricao}</td>
                <td>{orcamento.mes}/{orcamento.ano}</td>
                <td>R$ {orcamento.valorTotalInformado}</td>
                <td>R$ {orcamento.valorTotalCalculado}</td>
                <td>R$ {orcamento.diferencaCalculo}</td>
                <td>
                  <AiFillDelete onClick={() => handleDeleteClick(orcamento.id)} className="pointer" />
                  <FaSearchDollar className="pointer" onClick={() => props.setOrcamentoDetalhar(orcamento)}/>
                </td>
              </tr>))
          }
        </tbody>
      </table>
      <button type="button" class="btn btn-outline-dark" onClick={() => setClicouNoBotao(!clicouNoBotao)}>
        Novo Or??amento
      </button>

    {
        clicouNoBotao && (
            <div className="modal fade show" style={{ display: 'block' }}>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Descri????o" value={descricao} onChange={(e) => setDescricao(e.target.value)} />
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" className="form-control" placeholder="M??s" value={mes} onChange={(e) => setMes(e.target.value)} />
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Ano" value={ano} onChange={(e) => setAno(e.target.value)} />
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Valor total" value={valorTotalInformado} onChange={(e) => setValorTotalInformado(e.target.value)} />
                        </div>
                        <div class="input-group mb-3">
                            <textarea className="form-control" placeholder="Itens do or??amento(CSV):" value={itensOrcamentoCSV} onChange={(e) => setItensOrcamentoCSV(e.target.value)} />
                        </div>
                        <button type="button" className="btn btn-outline-dark" onClick={handleSaveClick}>Salvar</button>
                        <button type="button" className="btn btn-outline-dark" onClick={() => setClicouNoBotao(false)}>Cancelar</button>
                    </div>
                </div>
            </div>
        )
    }
    </>
  );
}
export default Orcamentos